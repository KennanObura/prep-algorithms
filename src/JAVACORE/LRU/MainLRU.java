package JAVACORE.LRU;

public class MainLRU {
    public static void main(String[] args) {
        LeastRecentlyUsed<Integer> lru = new LeastRecentlyUsedImp<>(2);
        System.out.println(lru.contains(1));
        lru.put(new NodeLRU<>(1, "first eleme"));
        lru.put(new NodeLRU<>(2, "second eleme"));
        lru.put(new NodeLRU<>(3, "third eleme"));
        lru.put(new NodeLRU<>(2, "second eleme"));
//        lru.put(new NodeLRU<>(4, "forth eleme"));
//        lru.put(new NodeLRU<>(5, "fifth eleme"));
//        lru.put(new NodeLRU<>(7, "seventh eleme"));
    }
}
