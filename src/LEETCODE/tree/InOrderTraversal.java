package LEETCODE.tree;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * Medium
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
public class InOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalUtil(root);
        return resultList;
    }

    private static void inorderTraversalUtil(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        resultList.add(root.val);
        inorderTraversalUtil(root.right);
    }

    private static List<Integer> resultList = new ArrayList<>();


}
