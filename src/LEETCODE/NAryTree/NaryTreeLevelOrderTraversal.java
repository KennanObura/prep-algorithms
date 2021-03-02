package LEETCODE.NAryTree;

import LEETCODE.NAryTree.treeclass.Node;

import java.util.*;

/**
 * 429. N-ary Tree Level Order Traversal
 * Medium
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * Example 2:
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class NaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        Node two = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node three = new Node(3, Arrays.asList(five, six));
        Node root = new Node(1, Arrays.asList(three, two, four));

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        Map<Integer, List<Integer>> map = new HashMap<>();


        levelOrder(root, 1, map);

        List<List<Integer>> result = new ArrayList<>();
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "|" + entry.getValue());
//        }

        for (int i = 1; i <= map.size(); i++) {
            result.add(new ArrayList<>(map.get(i)));
        }

        return result;
    }

    private static void levelOrder(Node root, int level, Map<Integer, List<Integer>> map) {

        if (root == null) return;

        map.putIfAbsent(level, new ArrayList<>());
        List<Integer> list = map.get(level);
        list.add(root.val);
        map.put(level, list);

        for (Node child : root.children)
            levelOrder(child, level + 1, map);

    }

}
