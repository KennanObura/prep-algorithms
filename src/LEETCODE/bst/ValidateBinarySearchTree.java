package LEETCODE.bst;

import LEETCODE.tree.treeclass.TreeNode;
/*
98. Validate Binary Search Tree
Medium

5518

653

Add to List

Share
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(8);


        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        long leftMax = Long.MIN_VALUE;
        long rightMin = Long.MAX_VALUE;
        return  isValidBST(root, leftMax, rightMin);
    }

    private static boolean isValidBST(TreeNode root, long leftMax, long rightMin) {
        if (root == null) return true;


        if (leftMax >= root.val || rightMin <= root.val)
            return false;

        boolean left = isValidBST(root.left, leftMax, root.val);
        boolean right = isValidBST(root.right, root.val, rightMin);
        return left & right;
    }
}
