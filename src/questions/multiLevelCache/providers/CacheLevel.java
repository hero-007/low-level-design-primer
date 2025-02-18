package questions.multiLevelCache.providers;

import multiLevelCache.eviction.IEvictionPolicy;
import multiLevelCache.exceptions.StorageFullException;
import multiLevelCache.models.CacheLevelData;
import multiLevelCache.models.ReadResponse;
import multiLevelCache.models.UsageResponse;
import multiLevelCache.models.WriteResponse;
import multiLevelCache.storage.ICacheStorage;

public class CacheLevel<Key, Value> implements ICacheLevel<Key, Value> {
    private CacheLevelData cacheLevelData;
    private ICacheStorage<Key, Value> cacheStorage;
    private ICacheLevel<Key, Value> nextLevel;
    private IEvictionPolicy<Key> evictionPolicy;

    public CacheLevel(CacheLevelData cacheLevelData, ICacheStorage<Key, Value> cacheStorage) {
        this.cacheLevelData = cacheLevelData;
        this.cacheStorage = cacheStorage;
        this.nextLevel = null;
    }

    @Override
    public ReadResponse<Value> get(Key key) {
        Integer totalReadTime = 0;
        Value value = cacheStorage.get(key);
        totalReadTime += cacheLevelData.getReadTimeMillis();

        if (value != null) {
            evictionPolicy.keyAccessed(key);
            return new ReadResponse<>(value, totalReadTime);
        }

        ReadResponse<Value> nextLevelResponse = nextLevel.get(key);
        totalReadTime += nextLevelResponse.getReadTimeMillis();

        return new ReadResponse<>(nextLevelResponse.getValue(), totalReadTime);
    }

    @Override
    public WriteResponse set(Key key, Value value) {
        Integer totalWriteTime = 0;

        try {
            cacheStorage.set(key, value);
        } catch (StorageFullException e) {
            Key keyToEvict = evictionPolicy.evict();
            cacheStorage.remove(keyToEvict);

            set(key, value);
        } finally {
            totalWriteTime = cacheLevelData.getWriteTimeMillis();
        }

        return new WriteResponse(totalWriteTime);
    }

    @Override
    public UsageResponse getUsage() {
        return cacheStorage.getUsage();
    }

    public void setNextLevel(ICacheLevel<Key, Value> nextLevel) {
        this.nextLevel = nextLevel;
    }
}
