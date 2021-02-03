package kennan.co.ke.graphs.base;

import java.util.LinkedList;


public class GraphNode<T> {
    public final T value;
    private final LinkedList<GraphNode<T>> neighbours;
    public boolean visited;

    public GraphNode(T value) {
        this.value = value;
        this.visited = false;
        this.neighbours = new LinkedList<>();
    }

    public void add(GraphNode<T> node) {
        this.neighbours.addFirst(node);
    }

    public LinkedList<GraphNode<T>> getNeighbours() {
        return this.neighbours;
    }
}
