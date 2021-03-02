package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

/*
https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
Given a binary tree, write a function that returns true if the tree satisfies below property.
For every node, data value must be equal to sum of data values in left and right children.
Consider data value as 0 for NULL children
 */
public class CheckRootSumProperty {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(3);

        System.out.println(checkSumProperty(root));

    }


    private static boolean checkSumProperty(TreeNode root) {
        /*
        In preOrder
            CASE
                root == null or is leaf child
                return true

                left val plus right val ~ root val
                return false

         Recur for left and right
         */


        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int leftSum = 0, rightSum = 0;


        if (root.left != null)
            leftSum = root.left.val;
        if (root.right != null)
            rightSum = root.right.val;

        if(root.val != leftSum + rightSum)
            return false;

        return  checkSumProperty(root.left) & checkSumProperty(root.right);
    }
}
