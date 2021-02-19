package LEETCODE.tree;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * Medium
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 */
public class PreOrderTraversalIterative {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(inorderTraversal(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        /*
                Push right
                push left
         */
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();


        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);


            list.add(current.val);
        }

        return list;
    }


}
