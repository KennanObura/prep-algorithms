package kennan.co.ke.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SimpleGraph {
    Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

    final private boolean isDirected;

    SimpleGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void create(int[][] edges) {
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new LinkedList<>());
            graph.putIfAbsent(edge[1], new LinkedList<>());

            addNeighbour(edge[0], edge[1]);
        }
    }

    private void addNeighbour(int origin, int destination) {
        LinkedList<Integer> neighbours = graph.get(origin);
        neighbours.addFirst(destination);
        graph.put(origin, neighbours);

        if (!this.isDirected) {
            neighbours = graph.get(destination);
            neighbours.addFirst(origin);
            graph.put(destination, neighbours);
        }
    }
}
