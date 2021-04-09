package JAVACORE.hashmap;

public interface CustomHashMap {

    boolean put(int key, String value);

    boolean containsKey(int key);

    MapNode remove(int key);
}
