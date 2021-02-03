package kennan.co.ke.graphs;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Vertex one = new Vertex(1);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        Vertex seven = new Vertex(7);
        Vertex eight = new Vertex(8);

        Graph graph = new Graph();
        graph.createEdge(one, three, 6);
        graph.createEdge(one, five, 3);
        graph.createEdge(five, three, 2);
        graph.createEdge(three, four, 1);
        graph.createEdge(four, six, 2);
        graph.createEdge(six, seven, 3);
        graph.createEdge(five, eight, 6);
        graph.createEdge(eight, seven, 4);

        findShortestPath(one);
        System.out.println("From one to seven " + seven.getDistance());

        Vertex end = seven;
        while(end != null && end.predecessor != null){
            System.out.print(end.value + " ->");
            end = end.predecessor;
        }
    }

    private static void findShortestPath(Vertex one) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(Vertex::getDistance));
        one.distance = 0;
        queue.add(one);
        one.visited = true;

        while (!queue.isEmpty()) {
            Vertex temp = queue.remove();

            for (Edge edge : temp.edges) {
                Vertex vertexTo = edge.destination;
                if (!vertexTo.visited) {
                    double newDistance = temp.distance + edge.weight;
                    if (newDistance < vertexTo.getDistance()) {
                        vertexTo.distance = newDistance;
                        vertexTo.predecessor = temp;
                        queue.add(vertexTo);
                    }
                }
            }
            temp.visited = true;
        }
    }

    private static class Graph {
        Set<Vertex> vertices;

        Graph() {
            this.vertices = new HashSet<>();
        }

        void createEdge(Vertex source, Vertex destination, double weight) {
            vertices.add(source);
            vertices.add(destination);
            source.addEdge(new Edge(source, destination, weight));
        }
    }
}

class Edge {
    Vertex source;
    Vertex destination;
    double weight;

    Edge(Vertex source, Vertex destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

}

class Vertex {
    boolean visited;
    LinkedList<Edge> edges;
    int value;
    double distance;
    Vertex predecessor;

    Vertex(int value) {
        this.value = value;
        this.visited = false;
        this.edges = new LinkedList<>();
        this.distance = Double.MAX_VALUE;
        this.predecessor = null;
    }

    public double getDistance() {
        return distance;
    }

    void addEdge(Edge edge) {
        this.edges.addFirst(edge);
    }
}
