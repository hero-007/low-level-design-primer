package questions.multiLevelCache.storage;

import multiLevelCache.exceptions.StorageFullException;
import multiLevelCache.models.UsageResponse;

public interface ICacheStorage<Key, Value> {
    Value get(Key key);
    void set(Key key, Value value) throws StorageFullException;
    Value remove(Key key);

    UsageResponse getUsage();
}
