package java2blog.graph.core;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int value;
    List<GraphNode> neighbours;
    public boolean visited;

    public GraphNode(int value) {
        this.value = value;
        this.neighbours = new ArrayList<>();
        this.visited = false;
    }


    public void addNeighbours(GraphNode neighbour) {
        this.neighbours.add(neighbour);
    }


    public void addNeighbours(List<GraphNode> neighbours) {
        this.neighbours = neighbours;
    }

    public int getValue() {
        return value;
    }

    public List<GraphNode> getNeighbours() {
        return this.neighbours;
    }

}
