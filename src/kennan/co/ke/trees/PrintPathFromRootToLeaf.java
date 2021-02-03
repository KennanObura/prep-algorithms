package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTree;
import kennan.co.ke.trees.base.BinaryTreeNode;

import java.util.ArrayList;

public class PrintPathFromRootToLeaf {
    public static void main(String[] args) {
        Integer[] items =  {2, 3, 5, 6, 8, 10, 33, 89, 100};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(items);

        BinaryTreeNode<Integer> root = binaryTree.getRoot();
        path(root);
    }

    private static void path(BinaryTreeNode<Integer> current) {
        ArrayList<BinaryTreeNode<Integer>> binaryTreeNodes = new ArrayList<>();
        path(current, binaryTreeNodes);
    }

    private static void path(BinaryTreeNode<Integer> current, ArrayList<BinaryTreeNode<Integer>> binaryTreeNodes) {
        if (current == null) return;

        binaryTreeNodes.add(current);

        if (current.left == null && current.right == null) {
            printPath(binaryTreeNodes);
        }

        if (current.left != null) path(current.left, binaryTreeNodes);
        if (current.right != null) path(current.right, binaryTreeNodes);

        binaryTreeNodes.remove(binaryTreeNodes.size() - 1);
    }

    private static void printPath(ArrayList<BinaryTreeNode<Integer>> binaryTreeNodes) {
        for (BinaryTreeNode<Integer> item : binaryTreeNodes)
            System.out.print(item.value + " ,");
        System.out.println();
    }
}
