package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print all possible
 * arrays that could have led to this tree.
 * <p>
 * Example
 * 2
 * / \
 * 1     3
 * <p>
 * <p>
 * <p>
 * Output: {2, 1, 3}, {2, 3, 1}
 */
public class BSTSequence {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(3);
//        root.right.left = new BinaryTreeNode<>(3);
//        root.right.right = new BinaryTreeNode<>(5);

        printBstSequence(root);
    }

    private static void printBstSequence(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedList<Integer>> result = generateSequence(root);

        for (LinkedList<Integer> items : result)
            System.out.println(Arrays.toString(items.toArray()));
    }

    private static ArrayList<LinkedList<Integer>> generateSequence(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        if (root == null) {
            results.add(new LinkedList<>());
            return results;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.addFirst(root.value);
        ArrayList<LinkedList<Integer>> leftNodes = generateSequence(root.left);
        ArrayList<LinkedList<Integer>> rightNodes = generateSequence(root.right);

        ArrayList<LinkedList<Integer>> mergedList = mergeLists(leftNodes, rightNodes, prefix, new ArrayList<>());
        results.addAll(mergedList);

        return results;
    }

    private static ArrayList<LinkedList<Integer>> mergeLists(
            ArrayList<LinkedList<Integer>> leftNodes,
            ArrayList<LinkedList<Integer>> rightNodes,
            LinkedList<Integer> prefix,
            ArrayList<LinkedList<Integer>> results) {

        for (LinkedList<Integer> left : leftNodes) {
            for (LinkedList<Integer> right : rightNodes) {
                ArrayList<LinkedList<Integer>> merged = new ArrayList<>();
                mergerUtil(left, right, merged, prefix);
                results.addAll(merged);
            }
        }
        return results;
    }

    private static void mergerUtil(LinkedList<Integer> left,
                                   LinkedList<Integer> right,
                                   ArrayList<LinkedList<Integer>> merged,
                                   LinkedList<Integer> prefix) {

        //Base case. Any of the list , left/right is empty
        if (left.size() == 0 || right.size() == 0) {
            /*
             * clone prefix,
             * append left to cloned
             * append right to cloned
             * append cloned to results
             */
            LinkedList<Integer> cloned = new LinkedList<>(prefix);
            cloned.addAll(left);
            cloned.addAll(right);
            merged.add(cloned);
            return;
        }


        /*
         *
         * 1. Remove the first @FIRST_LEFT item from left and store it
         * 2. Append FIST_LEFT to prefix
         * 3. recur
         * Fix back by
         * 4. removing FIRST_LEFT from prefix
         * 5. add back FIRST_LEFT to its original place, left
         *
         */

        int FIRST_LEFT = left.removeFirst();
        prefix.addLast(FIRST_LEFT);
        mergerUtil(left, right, merged, prefix);
        prefix.removeLast();
        left.addFirst(FIRST_LEFT);

        /*
         * Repeat same procedure as above, with RIGHT_FIRST
         *
         */

        int FIRST_RIGHT = right.removeFirst();
        prefix.addLast(FIRST_RIGHT);
        mergerUtil(left, right, merged, prefix);
        prefix.removeLast();
        right.addFirst(FIRST_RIGHT);


    }
}
