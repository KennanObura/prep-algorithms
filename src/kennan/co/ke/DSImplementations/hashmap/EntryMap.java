//package kennan.co.ke.DSImplementations.hashmap;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class EntryMap<K, V> {
//    private final EntryNode<K, V>[] buckets;
//    private int INITIAL_CAPACITY;
//    private int size;
//
//    public EntryMap() {
//        this.INITIAL_CAPACITY = 4 << 2; // 16
//        this.buckets = new EntryNode[INITIAL_CAPACITY];
//    }
//
//    public EntryMap(int capacity) {
//        this.buckets = new EntryNode[capacity];
//    }
//
//    public V get(K key) {
//
//        EntryNode<K, V> bucket = getBucket(key);
//
//        while (bucket != null) {
//            if (bucket.getKey().equals(key))
//                return bucket.getValue();
//            bucket = bucket.next;
//        }
//        return null;
//    }
//
//    private int getBucketIndex(K key) {
//        return this.getHashCode(key) & (INITIAL_CAPACITY - 1);
//    }
//
//
//    private EntryNode<K, V> getBucket(K key) {
//        return buckets[getBucketIndex(key)];
//    }
//
//    public K remove(K key) {
//
//        int internalSize = 0;
//
//        EntryNode<K, V> bucket = this.getBucket(key);
//
//        while (bucket != null) {
//            if (bucket.getKey().equals(key)) {
//                /*
//                 * When the size is more than 1, remove from linked list
//                 *  - Copy next value to current,
//                 *  - remove  next
//                 */
//                bucket.setValue(bucket.next.getValue());
//                bucket.next = null;
//                size--;
//                return key;
//
//            }
//            internalSize++;
//            bucket = bucket.next;
//        }
//
//        if (internalSize == 1) {
//            int index = this.getBucketIndex(key);
//            buckets[index] = null;
//            size--;
//        }
//        return key;
//    }
//
//    private int getHashCode(K key) {
//        int prime = 31;
//        int result = 1;
//        result = result * prime + key.hashCode();
//        return result;
//    }
//
//
//    public void put(K key, V value) {
//        EntryNode<K, V> entryNode = new EntryNode<>(key, value, null);
//
//        int index = getBucketIndex(key);
//
//        EntryNode<K, V> existing = getBucket(key);
//
//        if (existing == null) {
//            buckets[index] = entryNode;
//            size++;
//            return;
//        }
//
//        while (existing != null) {
//            if (existing.getKey().equals(key)) {
//                existing.setValue(value);
//                return;
//            }
//            existing = existing.next;
//        }
//
//
//        assert false;
//        if (existing.getKey().equals(key)) {
//            existing.setValue(value);
//        } else {
//            existing.next = entryNode;
//            size++;
//        }
//    }
//
//
//    public boolean isEmpty() {
//        return (size == 0);
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//}
//
//class MapTest {
//    @Test
//    private void testMap() {
//        EntryMap<String, String> myMap = new EntryMap<>();
//        myMap.put("USA", "Washington DC");
//        myMap.put("Nepal", "Kathmandu");
//        myMap.put("India", "New Delhi");
//        myMap.put("Australia", "Sydney");
//
//        assertNotNull(myMap);
//        assertEquals(4, myMap.getSize());
//        assertEquals("Kathmandu", myMap.get("Nepal"));
//        assertEquals("Sydney", myMap.get("Australia"));
//    }
//
//    public static void main(String[] args) {
//        EntryMap<String, String> myMap = new EntryMap<>();
//        myMap.put("USA", "Washington DC");
//        myMap.put("Nepal", "Kathmandu");
//        myMap.put("India", "New Delhi");
//        myMap.put("Australia", "Sydney");
//
//        System.out.println(myMap.get("Australia"));
//
//        System.out.println(myMap.getSize());
//    }
//}
