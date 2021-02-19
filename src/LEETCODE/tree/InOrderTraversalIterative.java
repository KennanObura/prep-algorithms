package LEETCODE.tree;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class InOrderTraversalIterative {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        /*
        Init empty result arraylist
        Init Stack
        Assign current rootNode to current

        while current IS NOT NULL or stack in NOT EMPTY
        assign current = current.left
        keep pushing till null

        print current

        assign current to current.right
        REPEATE
         */
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()){

            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);

            current = current.right;
        }


        return list;
    }


}
