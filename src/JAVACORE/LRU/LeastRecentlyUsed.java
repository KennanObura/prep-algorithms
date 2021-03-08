package JAVACORE.LRU;

public interface LeastRecentlyUsed<T> {

    void put(NodeLRU<T> nodeLRU);

    boolean contains(T id);
}
