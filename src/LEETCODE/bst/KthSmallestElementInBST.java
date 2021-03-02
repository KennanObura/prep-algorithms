package LEETCODE.bst;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
230. Kth Smallest Element in a BST
Medium

Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

 */

public class KthSmallestElementInBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);

        System.out.println(kthSmallest(root, 1));
    }


    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        kthSmallest(root, k, list);

        System.out.println(list);

        return list.get(k-1);
    }


    private static void kthSmallest(TreeNode root, int k, List<Integer> list) {
        if (root == null) return;

        kthSmallest(root.left, k-1, list);
        list.add(root.val);
        kthSmallest(root.right, k-1, list);
    }
}
