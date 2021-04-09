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
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.right.right = new TreeNode(5);
        A.left.right = new TreeNode(4);

        System.out.println(isCousins(A, 4, 5));

    }


    public static boolean isCousins(TreeNode root, int x, int y) {


        return isCousins(root, x, y, 0, null, new HashMap<>());
    }

    private static boolean isCousins(TreeNode root, int x, int y, int i, TreeNode parent, Map<Integer, Map<Integer, TreeNode>> kvMap) {
        if (root == null) return false;

        kvMap.putIfAbsent(i, new HashMap<>());

        Map<Integer, TreeNode> internal = kvMap.get(i);
        internal.put(root.val, parent);

        if (internal.containsKey(x) && internal.containsKey(y)) {
            TreeNode parentX = internal.get(x);
            TreeNode parentY = internal.get(y);

            return !parentY.equals(parentX);

        }
        kvMap.put(i, internal);

        return isCousins(root.left, x, y, i + 1, root, kvMap) ||
                isCousins(root.right, x, y, i + 1, root, kvMap);

    }
}
