package LEETCODE.lld;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 146. LRU Cache
 * Medium
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put",  "put",  "get",  "put",  "get", "put",   "get", "get",   "get"]
 * [[2],        [1, 1], [2, 2],  [1],   [3, 3],  [2],   [4, 4],  [1],   [3],    [4]]
 * Output
 * [null,       null,   null,    1,     null,     -1,       null, -1,   3,      4]
 * <p>
 * Explanation
 */


public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3)
        ;
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


    HashMap<Integer, Node> map;
    LinkedList<Node> list;
    final Integer CAPACITY;


    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();

    }

    public int get(int key) {
        if (containsKey(key)) {
            updateKey(key);
            return map.get(key).value;
        } else return -1;
    }

    private void updateKey(int key) {
        Node temp = map.get(key);
        list.remove(temp);
        list.addFirst(temp);
    }

    private boolean containsKey(int key) {
        return map.containsKey(key);
    }

    public void put(int key, int value) {
        if (containsKey(key))
            updateKey(key, value);
        else {
            if (capacityReached())
                evictLeastUsed();
            insertNew(key, value);
        }
    }

    private void insertNew(int key, int value) {
        Node node = new Node(key, value);
        map.put(key, node);
        list.addFirst(node);
    }

    private void evictLeastUsed() {
        Node node = list.removeLast();
        map.remove(node.key);
    }

    private boolean capacityReached() {
        return CAPACITY.equals(list.size()) || CAPACITY.equals(map.size());
    }

    private void updateKey(int key, int value) {
        Node temp = map.get(key);
        temp.value = value;
        map.put(key, temp);
        list.remove(temp);
        list.addFirst(temp);
    }


}
