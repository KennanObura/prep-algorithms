package kennan.co.ke.graphs;

import java.util.ArrayList;
import java.util.List;

public class PathsFromTargetToSource {
    public static void main(String[] args) {


    }

    static class Edge {
        public final int source, dest;

        private Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }

        // Factory method for creating a Edge immutable instance
        public static Edge of(int a, int b) {
            return new Edge(a, b);		// calls private constructor
        }
    }

    class Graph {
        // A List of Lists to represent an adjacency list
        List<List<Integer>> adjList = null;

        // Constructor
        Graph(List<Edge> edges, int N) {
            adjList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }

            // add edges to the undirected graph
            for (Edge edge: edges)
            {
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
            }
        }
    }
}
