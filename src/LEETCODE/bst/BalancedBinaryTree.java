package LEETCODE.bst;

import LEETCODE.tree.treeclass.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Easy
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: root = []
 * Output: true
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(16);


        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;


        int height = Math.abs(getHeight(root.left) - getHeight(root.right));

        if (height > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }


}
