package kennan.co.ke.DSImplementations.hashmap;

import java.util.Objects;

public class EntryNode<K, V> {
    private final K key;
    private V value;
    public EntryNode<K, V> next;

    public EntryNode(K key, V value, EntryNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }


    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EntryNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntryNode)) return false;
        EntryNode<?, ?> entryNode = (EntryNode<?, ?>) o;
        return Objects.equals(key, entryNode.key);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + key.hashCode();
        return result;
    }
}
