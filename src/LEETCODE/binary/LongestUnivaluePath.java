package LEETCODE.binary;


import java.util.HashSet;
import java.util.Set;

/**
 * 687. Longest Univalue Path
 * Medium
 * <p>
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of the path between two nodes is represented by the number of edges between them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,4,5,4,4,5]
 * Output: 2
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {

    }

    static int ANS = Integer.MIN_VALUE;
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        int length = longestUnivaluePath(root, root);
        ANS = Math.max(length, ANS);

        /**
         *
         * TODO WILL COME BACK. DEFINATELY Not a solution
         *
         */
        return ANS;

    }

    private static Set<TreeNode> set = new HashSet<>();

    private static int longestUnivaluePath(TreeNode root, TreeNode prev) {
        if (root == null || prev.val != root.val)
            return 0;

        int left = longestUnivaluePath(root.left, root) + 1;
        int right = longestUnivaluePath(root.right, root) + 1;
        return left + right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
