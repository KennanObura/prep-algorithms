package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

/*
https://www.techiedelight.com/check-skewed-binary-tree/
Has exactly one child
    1
        \
           3
          /
         10
        /
      12
        \
            6
 */
public class CheckSkwedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(5);


        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(10);
        root2.left.right.left.right = new TreeNode(5);

        System.out.println(isSkewed(root));

        System.out.println(isSkewed(root2));
    }


    private static boolean isSkewed(TreeNode root) {
        if (root == null) return true;

        if (root.left != null && root.right != null)
            return false;
        return isSkewed(root.left) & isSkewed(root.right);
    }
}
