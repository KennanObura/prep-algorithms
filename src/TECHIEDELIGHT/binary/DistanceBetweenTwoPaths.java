package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
https://www.techiedelight.com/distance-between-given-pairs-of-nodes-binary-tree

Given a binary tree, determine the distance between given pairs of nodes in it.
Distance between two nodes is defined as the total number of edges in the shortest path from one node and another.
 */
public class DistanceBetweenTwoPaths {
    public static void main(String[] args) {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        root.left = two;
        root.right = three;
        root.left.right = four;
        root.right.left = five;
        root.right.right = six;
        root.right.left.left = seven;
        root.right.left.right = eight;

        System.out.println(distanceBetweenNodes(root, two, six));

    }

    private static int distanceBetweenNodes(TreeNode root, TreeNode A, TreeNode B) {
        List<Integer> listA = new LinkedList<>();
        List<Integer> listB = new LinkedList<>();

        pathToNode(root, A, listA);
        pathToNode(root, B, listB);

        int i = 0;
        while (i < listA.size() && i < listB.size() && listA.get(i).equals(listB.get(i)))
            i++;

        int distanceA = 1;
        int j = i;
        while (j < listA.size() && listA.get(j) != A.val) {
            j++;
            distanceA++;
        }


        int distanceB = 1;
        j = i;
        while (j < listB.size() && listB.get(j) != B.val) {
            j++;
            distanceB++;
        }

        System.out.println(listA);
        System.out.println(listB);
        return distanceA + distanceB;
    }

    private static boolean pathToNode(TreeNode root, TreeNode node, List<Integer> list) {
        if (root == null) return false;

        list.add(root.val);

        if (root == node) return true;

        boolean left = pathToNode(root.left, node, list);
        boolean right = pathToNode(root.right, node, list);

        if (left | right) return true;

        list.remove(list.size() - 1);
        return false;
    }
}
