package JAVACORE.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeastRecentlyUsedImp<T> implements LeastRecentlyUsed<T> {

    Map<T, NodeLRU<T>> map;

    LinkedList<NodeLRU<T>> nodeList;

    final int CAPACITY;

    LeastRecentlyUsedImp(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>();
        nodeList = new LinkedList<>();
    }


    @Override
    public void put(NodeLRU<T> node) {
        if (!isCapacityReached()) {
            if (contains(node.getId()))
                update(node);
            else insert(node);
            System.out.println(node.getTitle() + " INSERTED");

        } else {
            System.out.println("CAPACITY REACHED " + map.size());
            NodeLRU<T> candidate = nodeList.removeLast();
            map.remove(candidate.getId());
            System.out.println(candidate.getTitle() + " EVICTED");
            insert(node);
        }

    }

    private void update(NodeLRU<T> node) {
        nodeList.removeLast();
        nodeList.addFirst(node);
    }

    private void insert(NodeLRU<T> node) {
        map.put(node.getId(), node);
        nodeList.addFirst(node);

        System.out.println(map);
        System.out.println(nodeList);
    }

    @Override
    public boolean contains(T id) {
        return map.containsKey(id);
    }


    private boolean isCapacityReached() {
        return map.size() == CAPACITY || nodeList.size() == CAPACITY;
    }
}
