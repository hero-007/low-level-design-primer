package questions.multiLevelCache.eviction;

import java.security.Key;

public class LRUEvictionPolicy implements IEvictionPolicy {
    @Override
    public void keyAccessed(Object o) {

    }

    @Override
    public Key evict() {
        return null;
    }
}
