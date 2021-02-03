package kennan.co.ke.graphs;


import kennan.co.ke.graphs.base.GraphNode;

import java.util.*;

public class TopologicalSort {
    static HashMap<Character, GraphNode<Character>> nodes;

    public static void main(String[] args) {
        Character[] projectArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        Pair[] dependencies = {
                new Pair('a', 'd'),
                new Pair('f', 'b'),
                new Pair('b', 'd'),
                new Pair('f', 'a'),
                new Pair('d', 'c')};


        Graph graph = new Graph(projectArray, dependencies);
        nodes = graph.getNodes();

        GraphNode<Character> root = nodes.get('f');


        Stack<GraphNode<Character>> graphNodeStack = topologicalSort(root, new Stack<>());

        while (!graphNodeStack.isEmpty())
            System.out.println(graphNodeStack.pop().value);
    }

    private static Stack<GraphNode<Character>> topologicalSort(GraphNode<Character> root, Stack<GraphNode<Character>> stack) {
        if (root == null) return stack;

        root.visited = true;

        for (GraphNode<Character> item : root.getNeighbours()) {
            if (!item.visited)
                topologicalSort(item, stack);
        }

        stack.push(root);

        return stack;
    }

}

class Graph {
    HashMap<Character, GraphNode<Character>> nodes;
    final Character[] projectArray;
    final Pair[] dependencies;

    Graph(Character[] projectArray, Pair[] dependencies) {
        this.projectArray = projectArray;
        this.dependencies = dependencies;
        nodes = new HashMap<>();
        create();
    }

    void create() {
        for (Character item : projectArray)
            nodes.put(item, new GraphNode<>(item));

        for (Pair pair : dependencies)
            createEdge(pair);

    }

    private void createEdge(Pair pair) {
        nodes.get(pair.parent).add(nodes.get(pair.child));
    }

    public HashMap<Character, GraphNode<Character>> getNodes() {
        return this.nodes;
    }

}

class Pair {
    char parent;
    char child;

    Pair(char parent, char child) {
        this.parent = parent;
        this.child = child;
    }
}


