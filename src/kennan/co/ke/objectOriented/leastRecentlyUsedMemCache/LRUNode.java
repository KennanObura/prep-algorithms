package kennan.co.ke.objectOriented.leastRecentlyUsedMemCache;

public class LRUNode<K, V> {
    public K key;
    V value;
    LRUNode<K, V> next;
    LRUNode<K, V> prev;

    public LRUNode(K key, V value) {
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString() {
        return "LRUNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
