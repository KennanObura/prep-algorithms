package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTree;
import kennan.co.ke.trees.base.BinaryTreeNode;

import java.util.LinkedList;

/**
 * Validate 8ST: Implement a function to check if a binary tree is a binary search tree.
 */
public class CheckIfTreeIsBST {
    public static void main(String[] args) {

        Integer[] items = {1, 3, 5, 6, 8, 10, 10, 89, 100};

//        Integer[] items = {2, 3, 5, 6, 8, 10, 33, 89, 100};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(items);

        BinaryTreeNode<Integer> root = binaryTree.getRoot();

//        System.out.println(isWrongTreeBST(root));
        isTreeBST(root);

    }


    /**
     * Simple but will fail for example
     * 4
     * / \
     * 2   6
     * / \
     * 1   5
     */
    private static boolean isWrongTreeBST(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        if (root.left != null && root.left.value > root.value) return false;
        if (root.right != null && root.value >= root.right.value) return false;
        return isWrongTreeBST(root.left) && isWrongTreeBST(root.right);
    }

    /**
     * Instead we keep track of max value on left subtree, and the min value on the right subtree.
     * if max is more than root, return false,
     * if min less than root, return false
     */

    private static void isTreeBST(BinaryTreeNode<Integer> root) {
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        System.out.println(isTreeBST(root, leftMax, rightMin));
    }

    private static boolean isTreeBST(BinaryTreeNode<Integer> root, int leftMax, int rightMin) {
        if (root == null) return true;


        if (leftMax > root.value || rightMin < root.value) return false;

        return isTreeBST(root.left, leftMax, root.value) &&
                isTreeBST(root.right, root.value, rightMin);
    }

}
