package kennan.co.ke.objectOriented.leastRecentlyUsedMemCache;

public interface MemCache<K, V> {
    LRUNode<K, V> get(K key);

    void set(K key, V value);

    void printContent();
}
