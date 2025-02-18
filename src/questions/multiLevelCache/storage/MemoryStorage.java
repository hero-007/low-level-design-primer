package questions.multiLevelCache.storage;

import multiLevelCache.exceptions.StorageFullException;
import multiLevelCache.models.UsageResponse;

import java.util.concurrent.ConcurrentHashMap;

public class MemoryStorage<Key, Value> implements ICacheStorage<Key, Value> {
    ConcurrentHashMap<Key, Value> storage;
    int size;

    public MemoryStorage(int size) {
        this.storage = new ConcurrentHashMap<>();
        this.size = size;
    }

    @Override
    public Value get(Object o) {
        return null;
    }

    @Override
    public void set(Key key, Value value) throws StorageFullException {
    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    @Override
    public UsageResponse getUsage() {
        float usage = (float) storage.size() / size;
        return new UsageResponse(usage);
    }
}
