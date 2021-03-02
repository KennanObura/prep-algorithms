package LEETCODE.bst;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;

/**
 * 897. Increasing Order Search Tree
 * Easy
 * <p>
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(7);

        TreeNode result = increasingBST(root);
        print(result);
    }

    private static void print(TreeNode node) {
        if (node == null) return;
        print(node.left);
        System.out.print(node.val + " ->");
        print(node.right);
    }


    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode result = new TreeNode(-1);
        TreeNode current = result;
        ArrayList<Integer> list = new ArrayList<>();
        increasingBST(root, list);

        for (int val : list) {
            current.right = new TreeNode(val);
            current = current.right;
        }
        return result.right;
    }

    private static void increasingBST(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        increasingBST(root.left, list);
        list.add(root.val);
        increasingBST(root.right, list);
    }
}
