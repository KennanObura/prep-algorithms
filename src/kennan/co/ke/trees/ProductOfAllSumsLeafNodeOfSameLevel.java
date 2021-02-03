package kennan.co.ke.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find sum of data of all leaves of a binary tree on same level and then multiply sums obtained of all levels.
 */
public class ProductOfAllSumsLeafNodeOfSameLevel {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(3);
        root.left.left.right = new Node(2);

        root.right.right = new Node(9);
        root.right.left = new Node(4);
        root.right.right.right = new Node(10);


        double sumProduct = getSumProductsOfLevelLeafs(root);
        System.out.println(sumProduct);
    }

    private static double getSumProductsOfLevelLeafs(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int sum;
        double prod = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();

                if (temp.left == null && temp.right == null)
                    sum += temp.val;

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

            if (sum != 0)
                prod *= sum;
        }
        return prod;
    }

    private static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

}
