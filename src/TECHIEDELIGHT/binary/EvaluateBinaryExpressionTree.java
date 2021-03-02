package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;
/*
https://www.techiedelight.com/evaluate-binary-expression-tree/
 */

public class EvaluateBinaryExpressionTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode((int) '+');
        root.left = new TreeNode('*');
        root.left.left = new TreeNode('-');
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(5);

        root.right = new TreeNode('/');
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(7);

        System.out.println(eveluateTree(root));


    }

    private static double eveluateTree(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null)
            return root.val;
        double left = eveluateTree(root.left);
        double right = eveluateTree(root.right);

        return doOperation(left, right, root);

    }

    private static double doOperation(double left, double right, TreeNode root) {
        if (root.val == '*')
            return left * right;
        else if (root.val == '+')
            return left + right;
        else if (root.val == '-')
            return left - right;
        else if (root.val == '/')
            return left / right;
        else
            return (double) ((int) left ^ (int) right);
    }
}
