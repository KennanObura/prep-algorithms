package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

/*
https://www.techiedelight.com/find-minimum-depth-binary-tree/
 */
public class MinimumDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
//        root.right.right.left = new TreeNode(11);
        root.left.left.right.right = new TreeNode(12);

        System.out.println(minimumDepth(root, 1));

    }


    private static int minimumDepth(TreeNode node, int count) {
        if (node == null) return Integer.MAX_VALUE;

        if (isLeaf(node)) return count;

        System.out.println(node.val + " --level" + count);
        int left = minimumDepth(node.left, count + 1);
        int right = minimumDepth(node.right, count + 1);

//        count -= 1;

        return Math.min(left, right);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
