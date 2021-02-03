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
public class BSTSequenceII {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(5);

//        possibleBstSequence(root);
    }

//    private static ArrayList<LinkedList<Integer>> possibleBstSequence(BinaryTreeNode<Integer> root) {
//        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
//
//        if(root == null){
//            results.add(new LinkedList<>());
//            return results;
//        }
//    }


}
