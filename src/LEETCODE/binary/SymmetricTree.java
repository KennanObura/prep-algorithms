package LEETCODE.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.*;

/**
 * 101. Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */
public class SymmetricTree {
    public static void main(String[] args) {

        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(3);
        A.left.right = new TreeNode(4);

        A.right = new TreeNode(2);
        A.right.right = new TreeNode(3);
        A.right.left = new TreeNode(4);

        System.out.println(isSymmetric(A));
    }


    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;


        return isSymmetricIte(root, root);


    }

    private static boolean isSymmetric(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;

        if (A.val != B.val) return false;

        return isSymmetric(A.left, B.right) &&
                isSymmetric(A.right, B.left);
    }


    private static boolean isSymmetricIte(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(A);
        queue.add(B);

        while (!queue.isEmpty()){
            TreeNode nodeA = queue.remove();
            TreeNode nodeB = queue.remove();

            if(nodeA == null && nodeB == null) continue;

            if(nodeA == null || nodeB == null) return false;
            if(nodeA.val != nodeB.val) return false;

            queue.add(nodeA.left);
            queue.add(nodeB.right);
            queue.add(nodeA.right);
            queue.add(nodeB.left);
        }

        return true;

    }


}
