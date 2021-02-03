package kennan.co.ke.graphs;

import kennan.co.ke.graphs.base.Graph;
import kennan.co.ke.graphs.base.GraphBuilder;
import kennan.co.ke.graphs.base.GraphNode;

import java.util.LinkedList;
import java.util.Queue;






/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class PathBetweenNodes {
    public static void main(String[] args) {
        GraphBuilder graphBuilder = new GraphBuilder();
        Graph<Integer> graph = graphBuilder.graph();
        GraphNode<Integer> root = graphBuilder.getRoot();

//        graph.doBreathFirstSearch();
        System.out.println(pathExist(root, new GraphNode<>(80)));

    }

    private static boolean pathExist(GraphNode<Integer> root, GraphNode<Integer> node) {

        Queue<GraphNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        root.visited = true;

        while (!queue.isEmpty()) {
            GraphNode<Integer> temp = queue.remove();

            if (temp.value.equals(node.value))
                return true;

            for (GraphNode<Integer> item : temp.getNeighbours()) {
                if (item != null && !item.visited) {
                    item.visited = true;
                    queue.add(item);
                }
            }
        }
        return false;
    }
}
