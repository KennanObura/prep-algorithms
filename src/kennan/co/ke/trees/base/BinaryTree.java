package kennan.co.ke.trees.base;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private final T[] nodes;

    public BinaryTree(T[] nodes) {
        this.nodes = nodes;
        create();
    }

    private void create() {
        root = create(0, nodes.length - 1);
    }

    private BinaryTreeNode<T> create(int start, int end) {
        if (start > end) return null;

        int mid = getMid(start, end);
        BinaryTreeNode<T> root = new BinaryTreeNode<>(nodes[mid]);
        root.left = create(start, mid - 1);
        root.right = create(mid + 1, end);
        return root;
    }

    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }


    private void inOrder() {
        inOrder(this.root);
    }

    private void postOrder() {
        postOrder(root);
    }

    private void inOrder(BinaryTreeNode<T> root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        System.out.print(root.value + ",");
        if (root.right != null) inOrder(root.right);
    }

    private void postOrder(BinaryTreeNode<T> root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        if (root.right != null) inOrder(root.right);
        System.out.print(root.value + ",");
    }


    /*
    Test
     */
    public static void main(String[] args) {
        Integer [] items = {2,3,5,6,8,10,33,89};

        BinaryTree<Integer> binaryTree = new BinaryTree<>(items);
        binaryTree.inOrder();
        System.out.println();
        binaryTree.postOrder();

    }
}
