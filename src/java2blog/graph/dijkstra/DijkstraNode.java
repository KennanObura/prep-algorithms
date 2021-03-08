package java2blog.graph.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraNode{
    private List<DijkstraEdge> edgeList;
    private boolean visited;
    private double distance;
    private DijkstraNode predecessor;
    final private String value;

    DijkstraNode(String value) {
        this.value = value;
        edgeList = new ArrayList<>();
        distance = Integer.MAX_VALUE;
        predecessor = null;
        visited = false;
    }

    public DijkstraNode getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(DijkstraNode predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<DijkstraEdge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<DijkstraEdge> edgeList) {
        this.edgeList = edgeList;
    }

    public String getValue() {
        return value;
    }

    public void addNeighbour(DijkstraEdge dijkstraEdge) {
        this.edgeList.add(dijkstraEdge);
    }

}



