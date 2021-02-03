package kennan.co.ke.graphs.base;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Graph<T> {
    final GraphNode<T> root;
    final boolean directed;

    Graph(GraphNode<T> root, boolean directed) {
        this.root = root;
        this.directed = directed;
    }


    public void addEdge(GraphNode<T> source, GraphNode<T> destination) {
        source.add(destination);
        if (!directed)
            destination.add(source);
    }


    public void doBreathFirstSearch() {
        Queue<GraphNode<T>> queue = new LinkedList<>();

        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode<T> temp = queue.remove();
            System.out.print(temp.value + " ,");
            for (GraphNode<T> item : temp.getNeighbours()) {
                if (item != null && !item.visited) {
                    item.visited = true;
                    queue.add(item);
                }
            }
        }
        System.out.println();
    }


    void doDepthFirstSearch() {
        Stack<GraphNode<T>> stack = new Stack<>();
        root.visited = true;
        stack.add(root);

        while (!stack.isEmpty()) {
            GraphNode<T> temp = stack.pop();
            System.out.print(temp.value + " ,");
            for (GraphNode<T> item : temp.getNeighbours()) {
                if (item != null && !item.visited) {
                    item.visited = true;
                    stack.push(item);
                }
            }
        }
        System.out.println();
    }

    void doDepthFirstSearchRecur() {
        doDepthFirstSearchRecur(root);
    }

    private void doDepthFirstSearchRecur(GraphNode<T> current) {
        if (current == null) return;
        current.visited = true;
        System.out.print(current.value + " ,");
        for (GraphNode<T> item : current.getNeighbours()) {
            if (item != null && !item.visited)
                doDepthFirstSearchRecur(item);
        }
    }
}



