package JAVACORE.hashmap;

import java.util.Objects;

public class MapNode {
    private  int key;
    private  String value;

    public MapNode(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapNode)) return false;
        MapNode mapNode = (MapNode) o;
        return key == mapNode.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "MapNode{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
