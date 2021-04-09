package JAVACORE.hashmap;

import java.util.Arrays;
import java.util.LinkedList;

/*
- For simplicity, use array of linkedlist
- LinkedList used for chaining in case of collision
- Insert item
    - Get hashcode of the object key
    - get the index using modulo of hashcode of array length
        hashcode % length
    - if elem array exist in slot
        chain to the last of LinkedList

        returns the value

 - Contains
    - Get hashcode of the object key
    - get index
    - check in map

 - Remove
    - Get hashcode of the object key
    - get index
    - checks if exist
    - remove from chain

 */
public class CustomHashMapImp implements CustomHashMap {

    private final LinkedList<MapNode>[] linkedMap;
    private final int INITIAL_CAPACITY;

    public CustomHashMapImp() {
        this.INITIAL_CAPACITY = 6 << 2;
        linkedMap = new LinkedList[INITIAL_CAPACITY];
    }


    @Override
    public boolean put(int key, String value) {
        MapNode node = new MapNode(key, value);
        int index = getIndex(key);
        LinkedList<MapNode> internal;
        if (linkedMap[index] == null) {
            internal = new LinkedList<>();
            internal.addLast(node);
            linkedMap[index] = internal;
        } else {
            internal = linkedMap[index];
            for (MapNode item : internal)
                if (item.getKey() == key) {
                    item.setValue(value);
                    return true;
                }

            internal.addLast(node);
        }
        return false;
    }

    @Override
    public boolean containsKey(int key) {
        int index = getIndex(key);
        if (linkedMap[index] == null)
            return false;

        LinkedList<MapNode> internal = linkedMap[index];
        for (MapNode item : internal)
            if (item.getKey() == key)
                return true;
        return false;
    }

    @Override
    public MapNode remove(int key) {
        int index = getIndex(key);
        if (linkedMap[index] == null)
            throw new IllegalArgumentException("No value associated to key found");

        LinkedList<MapNode> internal = linkedMap[index];
        MapNode removed = null;

        for (MapNode item : internal)
            if (item.getKey() == key) {
                removed = item;
                internal.remove(item);
                break;
            }

        return removed;
    }

    private int getIndex(int key) {
        return hashCode(key) % INITIAL_CAPACITY;
    }

    private int hashCode(int key) {
        return String.valueOf(key).hashCode();
    }

    @Override
    public String toString() {
        return "CustomHashMapImp{" +
                "linkedMap=" + Arrays.toString(linkedMap) +
                '}';
    }
}
