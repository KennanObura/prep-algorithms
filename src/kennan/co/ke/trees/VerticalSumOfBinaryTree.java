package kennan.co.ke.trees;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumOfBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(30);

        root.right = new Node(60);
        root.right.left = new Node(50);
        root.right.right = new Node(70);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        verticalSum(root, 0, map);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

//        System.out.print(max);

    }

    /**
     * Approach
     * Given Root tree
     * initialize level = 0;
     * We need to maintail treeMap with level as key and value as sum
     * 1. Traverse tree in inorder fashion
     * 2. when left, level --;
     * 3. calculate sum
     * 4. when right, level ++;
     */
    private static void verticalSum(Node root, int level, TreeMap<Integer, Integer> map) {
        if (root == null) return;

        verticalSum(root.left, level - 1, map);
        map.put(level, map.getOrDefault(level, 0) + root.val);
        verticalSum(root.right, level+1, map);
    }

    private static class Node {
        Node left;
        Node right;
        final int val;

        Node(int val) {
            this.val = val;
        }
    }
}
