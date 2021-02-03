package kennan.co.ke.trees;


import kennan.co.ke.trees.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintPathFromRootToLeafRev {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(40);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(60);
        root.left.left = new BinaryTreeNode<>(10);
        root.left.right = new BinaryTreeNode<>(30);
        root.left.left.left = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(50);
        root.right.left.right = new BinaryTreeNode<>(55);
        root.right.right = new BinaryTreeNode<>(70);

        printPath(root, new ArrayList<>());
        System.out.println(result);
    }

    private static List<ArrayList<Integer>> result = new ArrayList<>();

    private static void printPath(BinaryTreeNode<Integer> root, ArrayList<Integer> innerList) {
        if (root == null) return;

        innerList.add(root.value);

        if (root.left == null && root.right == null) {
            result.add(innerList);
            return;
        }

        printPath(root.left, innerList);
        printPath(root.right, innerList);

        innerList.remove(innerList.size() - 1);
    }


}
