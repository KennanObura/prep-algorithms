package java2blog.graph.dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        DijkstraNode vertexA = new DijkstraNode("A");
        DijkstraNode vertexB = new DijkstraNode("B");
        DijkstraNode vertexC = new DijkstraNode("C");
        DijkstraNode vertexD = new DijkstraNode("D");
        DijkstraNode vertexE = new DijkstraNode("E");

        vertexA.addNeighbour(new DijkstraEdge(10, vertexA, vertexC));
        vertexA.addNeighbour(new DijkstraEdge(17, vertexA, vertexB));
        vertexC.addNeighbour(new DijkstraEdge(5, vertexC, vertexB));
        vertexC.addNeighbour(new DijkstraEdge(9, vertexC, vertexD));
        vertexC.addNeighbour(new DijkstraEdge(11, vertexC, vertexE));
        vertexB.addNeighbour(new DijkstraEdge(1, vertexB, vertexD));
        vertexD.addNeighbour(new DijkstraEdge(6, vertexD, vertexE));

        getShortestPathFromVertex(vertexA);
        System.out.println("Distance from A  to E " + vertexE.getDistance());

    }


    private static void getShortestPathFromVertex(DijkstraNode node) {
        /*
        Have two concrate classes, Node, Edge
        Node (DijkstraNode) with members
            list of edges
            distance // set to infinity
            visited,
            predecessor, //track parent
            value

       Edge
            source
            target
            weight


       shortestPath() ->
            define priority queue
            set the source node distance = 0
            put source node to queue
            mark it visited

            do while queue is not empty
                pop from queue, temp
                for edges in temp
                    if not visited
                        calculate min distance
                mark temp as visited

         */


        PriorityQueue<DijkstraNode> queue = new PriorityQueue<>(new Comparator<DijkstraNode>() {
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });

        node.setDistance(0);
        queue.add(node);

        node.setVisited(true);


        while (!queue.isEmpty()) {
            // Getting the minimum distance vertex from priority queue
            DijkstraNode actualVertex = queue.poll();

            for (DijkstraEdge edge : actualVertex.getEdgeList()) {

                DijkstraNode target = edge.getTarget();
                if (!target.isVisited()) {
                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    if (newDistance < target.getDistance()) {
                        queue.remove(target);
                        target.setDistance(newDistance);
                        target.setPredecessor(actualVertex);
                        queue.add(target);
                    }
                }
            }

            actualVertex.setVisited(true);

        }
    }
}
