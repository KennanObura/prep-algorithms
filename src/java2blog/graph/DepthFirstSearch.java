package java2blog.graph;

import java2blog.graph.core.GraphNode;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    public static void main(String[] args) {
        GraphNode node40 = new GraphNode(40);
        GraphNode node10 = new GraphNode(10);
        GraphNode node20 = new GraphNode(20);
        GraphNode node30 = new GraphNode(30);
        GraphNode node60 = new GraphNode(60);
        GraphNode node50 = new GraphNode(50);
        GraphNode node70 = new GraphNode(70);

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        doDFSRecursive(node40);
//        doDFSStack(node40);
    }


    private static void doDFSRecursive(GraphNode node) {
        node.visited = true;
        System.out.print(node.getValue() + " ");
        List<GraphNode> neighbours = node.getNeighbours();

        for (GraphNode child : neighbours)
            if (!child.visited)
                doDFSRecursive(child);
    }


    private static void doDFSStack(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();

        stack.push(node);
        node.visited = true;

        while (!stack.isEmpty()) {
            GraphNode temp = stack.pop();

            List<GraphNode> neighbours = temp.getNeighbours();

            for (GraphNode neighbour : neighbours)
                if (!neighbour.visited) {
                    neighbour.visited = true;
                    stack.push(neighbour);
                }

            System.out.print(temp.getValue()+ " ");
        }
    }

}
