package LEETCODE.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(9);
        A.right = new TreeNode(20);
        A.right.left = new TreeNode(15);
        A.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(A));

    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(root, 0, map, true);

        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet())
            result.add(entry.getValue());

        return result;
    }

    private static void zigzagLevelOrder(TreeNode root, int level, Map<Integer, LinkedList<Integer>> map, boolean direction) {
        if (root == null) return;

        map.putIfAbsent(level, new LinkedList<>());

        if (direction)
            map.get(level).addLast(root.val);
        else
            map.get(level).addFirst(root.val);

        zigzagLevelOrder(root.left, level + 1, map, !direction);
        zigzagLevelOrder(root.right, level + 1, map, !direction);

    }
}
