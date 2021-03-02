package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.left.left.right.left = new TreeNode(12);
        root.left.left.right.right = new TreeNode(13);
        root.right.right.left.left = new TreeNode(14);


        System.out.println(boundaryTraversal(root));
    }

    private static List<Integer> boundaryTraversal(TreeNode node) {
        result.add(node.val);
        traverseLeftNodes(node.left);
        traverseLeafNodes(node);
        traverseRightNodes(node.right);

        return result;
    }

    static List<Integer> result = new ArrayList<>();

    private static void traverseLeftNodes(TreeNode node) {
        if (node.left == null && isLeaf(node)) return;

        result.add(node.val);

        traverseLeftNodes(node.left != null ? node.left : node.right);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void traverseLeafNodes(TreeNode node) {
        if (node == null) return;

        if (node.left == null && node.right == null)
            result.add(node.val);

        traverseLeafNodes(node.left);
        traverseLeafNodes(node.right);
    }

    private static void traverseRightNodes(TreeNode node) {
        if (node.right == null) return;

        traverseRightNodes(node.right);
        result.add(node.val);
    }


}
