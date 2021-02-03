package kennan.co.ke.graphs.base;

public class GraphBuilder {
    private GraphNode<Integer> root;

    public GraphBuilder() {
        this.root = new GraphNode<>(8);

    }


    public GraphNode<Integer> getRoot() {
        return root;
    }

    public Graph<Integer> graph() {
        return create();
    }

    private Graph<Integer> create() {

        GraphNode<Integer> node9 = new GraphNode<>(9);
        GraphNode<Integer> node10 = new GraphNode<>(10);
        GraphNode<Integer> node20 = new GraphNode<>(20);
        GraphNode<Integer> node30 = new GraphNode<>(30);
        GraphNode<Integer> node45 = new GraphNode<>(45);
        GraphNode<Integer> node55 = new GraphNode<>(55);


        Graph<Integer> graph = new Graph<>(root, false);

        graph.addEdge(root, node9);
        graph.addEdge(root, node10);
        graph.addEdge(root, node20);
        graph.addEdge(node10, node20);
        graph.addEdge(node20, node30);
        graph.addEdge(node30, node55);
        graph.addEdge(node9, node30);
        graph.addEdge(node9, node45);

        return graph;
    }
}
