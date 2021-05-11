package LEETCODE.MSPRO;

import java.util.ArrayList;
import java.util.List;

/**
 * 706. Design HashMap
 * Easy
 * <p>
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * Implement the MyHashMap class:
 * <p>
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 */
public class DesignHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2, 1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }


}

class MyMapNode {
    private final int key;
    private int value;

    MyMapNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class MyHashMap {

    List<MyMapNode>[] map;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        map = new List[16 << 4];
        System.out.println(map.length);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = getIndex(key);

        MyMapNode node = new MyMapNode(key, value);
        if (map[index] == null) {
            map[index] = new ArrayList<>();
            map[index].add(node);
            return;
        }

        List<MyMapNode> current = map[index];
        for (MyMapNode existing : current)
            if (existing.getKey() == key) {
                existing.setValue(value);
                return;
            }

        map[index].add(node);
    }


    private int getIndex(int key) {
        return hashCode(key) % map.length;
    }

    private int hashCode(int key) {
        return String.valueOf(key).hashCode();
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = getIndex(key);
        if (map[index] == null)
            return -1;

        for (MyMapNode node : map[index])
            if (node.getKey() == key)
                return node.getValue();

        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = getIndex(key);
        if (map[index] == null) {
            //key not available
            return;
        }


        map[index].removeIf(node -> node.getKey() == key);

        if(map[index].isEmpty())
            map[index] = null;


    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
