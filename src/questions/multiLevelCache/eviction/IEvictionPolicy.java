package questions.multiLevelCache.eviction;

public interface IEvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evict();
}
