package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;


public class MinimalTree {
    final int[] numbers;
    final int size;
    BinaryTreeNode<Integer> root;

    MinimalTree(int size) {
        this.size = size;
        this.numbers = new int[size];

        for (int i = 0; i < size; i++)
            numbers[i] = i+1;
    }


    void toBinaryTree() {
        for (int i: numbers)
            System.out.print(i + " ,");
        System.out.println();
        root = toBinaryTree(0, size - 1);
    }

    private BinaryTreeNode<Integer> toBinaryTree(int start, int end) {
        if (start > end) return null;

        int mid = getMid(start, end);

        BinaryTreeNode<Integer> current = new BinaryTreeNode<>(numbers[mid]);
        current.left = toBinaryTree(start, mid - 1);
        current.right = toBinaryTree(mid + 1, end);
        return current;
    }


    private void inOrder() {
        inOrder(root);
    }

    private void postOrder() {
        postOrder(root);
    }

    private void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        System.out.print(root.value + ",");
        if (root.right != null) inOrder(root.right);
    }

    private void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        if (root.right != null) inOrder(root.right);
        System.out.print(root.value + ",");
    }

    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }


    public static void main(String[] args) {
        MinimalTree tree = new MinimalTree(9);

        tree.toBinaryTree();
        System.out.println("In Order");
        tree.inOrder();
        System.out.println("Post Order");
        tree.postOrder();
    }

}
