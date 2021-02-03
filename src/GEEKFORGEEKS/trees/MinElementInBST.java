package GEEKFORGEEKS.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinElementInBST {
    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(7);

        System.out.println(minElement(root));

    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private static int minElement(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        int minElem = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node item = queue.remove();
            minElem = Math.min(item.data, minElem);

            if (item.left != null)
                queue.add(item.left);
            if (item.right != null)
                queue.add(item.right);

        }
        return minElem;
    }
}
