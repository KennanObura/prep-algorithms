package LEETCODE.tree;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * Medium
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 */
public class PostOrderTraversalIterative {
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

         */
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
            temp.push(current);
        }

        while (!temp.isEmpty())
            list.add(temp.pop().val);

        return list;
    }


}
