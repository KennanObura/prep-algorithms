package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

public class IsTreeBalancedUsingPostOrder {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(40);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(60);
        root.left.left = new BinaryTreeNode<>(10);
        root.left.right = new BinaryTreeNode<>(30);
        root.left.left.left = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(50);
        root.right.left.right = new BinaryTreeNode<>(55);
        root.right.right = new BinaryTreeNode<>(70);

        System.out.println(isTreeBalanced(root, 0).balanced);
    }

    private static class Result {
        final int height;
        final boolean balanced;

        Result(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    /*
     * Traverse tree in post order, upwards
     * calculate heights of both left and right subtrees
     * check if balanced
     *
     */
    private static Result isTreeBalanced(BinaryTreeNode<Integer> root, int level) {
        if (root == null) return new Result(-1, true);

        Result leftResult = isTreeBalanced(root.left, level + 1);
        Result rightResult = isTreeBalanced(root.right, level + 1);

        boolean heightBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;

        boolean subtreeBalanced = leftResult.balanced && rightResult.balanced;

        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new Result(height, subtreeBalanced && heightBalanced);
    }

}
