package kennan.co.ke.objectOriented.leastRecentlyUsedMemCache;

import java.util.HashMap;
import java.util.Map;


public class MemCacheImp<K, V> implements MemCache<K, V> {
    private LRUNode<K, V> recent; // head
    private LRUNode<K, V> least; // tail
    Map<K, LRUNode<K, V>> map;
    private final int CAPACITY;

    MemCacheImp(int capacity) {
        this.CAPACITY = capacity;
        this.map = new HashMap<>();
    }


    /**
     * Look in a map, if its a hit
     * - detach from current position and make it head/recent
     *
     * @return looked up Node
     */
    @Override
    public LRUNode<K, V> get(K key) {
        if (!map.containsKey(key)) return null;

        LRUNode<K, V> node = map.get(key);
        deleteFromCurrentPosition(node);
        setAsRecent(node);

        return node;
    }

    private void setAsRecent(LRUNode<K, V> node) {


        if (recent == null) {
            recent = node;
            return;
        }

        node.next = recent;
        recent.prev = node;

        recent = node;

        if (least == null)
            least = recent;
    }

    private void deleteFromCurrentPosition(LRUNode<K, V> node) {
        if (node == null) return;

        if (node.prev != null)
            node.prev.next = node.next;
        else
            // set as head
            recent = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            least = node.prev;
    }


    @Override
    public void set(K key, V value) {
        /*
         * Check if we have it / present in map
         *  - update value
         *  - delete from current position and make it head
         * else (is New)
         *  is capacity  reached ?
         *      remove old as tail/ least
         *      remove  old from map
         *   create new, append it to head of list
         *   include in map
         *   append new to head
         *
         *
         */
        if (map.containsKey(key)) {
            LRUNode<K, V> existing = map.get(key);
            existing.value = value;
            deleteFromCurrentPosition(existing);
            setAsRecent(existing);
            return;
        }


        if (map.size() >= CAPACITY) {
            /*
             * Delete tail
             * Delete from map
             */
            map.remove(least.key);
            deleteFromCurrentPosition(least);
        }

        LRUNode<K, V> newNode = new LRUNode<>(key, value);
        setAsRecent(newNode);
        map.put(key, newNode);
    }

    @Override
    public void printContent() {
        LRUNode<K, V> current = recent;
        while (current != null) {
            System.out.println(current.value + "-->");
            current = current.next;
        }
        System.out.println();

//        for (Map.Entry<K, LRUNode<K, V>> entry : map.entrySet())
//            System.out.println(entry.getKey() + " - " + entry.getValue());

    }


    public static void main(String[] args) {
        MemCache<Integer, String> memCache = new MemCacheImp<>(5);
        memCache.set(1, "Manchester");
        memCache.set(3, "Friends");
        memCache.set(5, "Lorester");
        memCache.set(1, "Manchester 76");
        memCache.set(3, "Friends");
//
        memCache.set(4, "Main chick");
        memCache.set(2, "Beryl");
        memCache.set(5, "Lorester de coupe");
        memCache.set(6, "Free world");
        memCache.set(7, "Seventh item");
        memCache.set(3, "Friends");
        memCache.set(2, "Beryl");
        memCache.printContent();

    }
}
