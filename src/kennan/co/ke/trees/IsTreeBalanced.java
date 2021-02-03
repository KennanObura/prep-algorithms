package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTree;
import kennan.co.ke.trees.base.BinaryTreeNode;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
public class IsTreeBalanced {
    public static void main(String[] args) {
        Integer[] items = {2, 3, 5, 6, 8, 10, 33, 89, 100};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(items);

        BinaryTreeNode<Integer> root = binaryTree.getRoot();

        checkBalanced(root);
    }

    private static void checkBalanced(BinaryTreeNode<Integer> root) {

//        if (isBalanced(root)) System.out.println("Is balanced ");
        if (isBalancedEfficient(root)) System.out.println("Is balanced ");
    }

    private static boolean isBalancedEfficient(BinaryTreeNode<Integer> root) {
        int height = checkHeight(root);
        return height != Integer.MIN_VALUE;
    }

    private static int checkHeight(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*
     * Algorithm works but not very efficient, on each node, we calculate height on its sub tree. (log n)
     *  O(NlogN)
     *
     */
    private static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        int heightDifference = getHeightDifference(root);
        if (heightDifference > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeightDifference(BinaryTreeNode<Integer> root) {
        return Math.abs(getHeight(root.left) - getHeight(root.right));
    }

    private static int getHeight(BinaryTreeNode<Integer> node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }


}
