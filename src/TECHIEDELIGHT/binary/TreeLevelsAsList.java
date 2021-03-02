package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TreeLevelsAsList {
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

        transformLevelNodesIntoList(root);
    }


    private static void transformLevelNodesIntoList(TreeNode node) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        transformLevelNodesIntoList(node, 1, map);

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "| ");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }

    private static void transformLevelNodesIntoList(TreeNode node, int level, Map<Integer, ArrayList<Integer>> map) {
        if (node == null) return;

        map.putIfAbsent(level, new ArrayList<>());

        ArrayList<Integer> list = map.get(level);

        list.add(node.val);
        map.put(level, list);

        transformLevelNodesIntoList(node.left, level + 1, map);
        transformLevelNodesIntoList(node.right, level + 1, map);
    }
}
