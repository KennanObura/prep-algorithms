package java2blog.graph.dijkstra;

public class DijkstraEdge {
    private double weight;
    private DijkstraNode source;
    private DijkstraNode target;


    public DijkstraEdge(double weight, DijkstraNode source, DijkstraNode target) {
        this.weight = weight;
        this.source = source;
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public DijkstraNode getSource() {
        return source;
    }

    public DijkstraNode getTarget() {
        return target;
    }
}
