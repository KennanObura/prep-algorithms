package LEETCODE.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 993. Cousins in Binary Tree
 * Easy
 * <p>
 * Share
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 */
public class CousinsInBinaryTreeII {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.right.right = new TreeNode(5);
        A.left.right = new TreeNode(4);

        System.out.println(isCousins(A, 2, 3));

    }


    static class NodeWrapper {
        TreeNode node;
        TreeNode parent;
        int level;

        NodeWrapper(TreeNode node, TreeNode parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }
    }


    public static boolean isCousins(TreeNode root, int x, int y) {

        NodeWrapper nodeA = new NodeWrapper(null, null, -1);
        NodeWrapper nodeB = new NodeWrapper(null, null, -1);
        findNode(root, null, x, 0, nodeA);
        findNode(root, null, y, 0, nodeB);

        return nodeA.level != -1 && nodeA.level == nodeB.level && !nodeA.parent.equals(nodeB.parent);

    }

    private static void findNode(TreeNode root, TreeNode parent, int x, int level, NodeWrapper node) {
        if (root == null) return;

        if (root.val == x) {
            node.level = level;
            node.node = root;
            node.parent = parent;
            return;
        }

        findNode(root.left, root, x, level + 1, node);
        findNode(root.right, root, x, level + 1, node);
    }


}
