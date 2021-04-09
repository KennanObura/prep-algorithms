package LEETCODE.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 102. Binary Tree Level Order Traversal
 * Medium
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(9);
        A.right = new TreeNode(20);
        A.right.left = new TreeNode(15);
        A.right.right = new TreeNode(7);


        List<List<Integer>> result = levelOrder(A);



        System.out.println(result);

    }

    private static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Map<Integer, List<Integer>> map = new HashMap<>();

        levelOrder(root, 0, map);



        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            result.add(entry.getValue());

        return result;

    }

    private static void levelOrder(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) return;

        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);

        levelOrder(root.left, level + 1, map);
        levelOrder(root.right, level + 1, map);
    }
}

