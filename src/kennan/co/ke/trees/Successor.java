package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTree;
import kennan.co.ke.trees.base.BinaryTreeNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 */
public class Successor {

    BinaryTreeNode<Integer> successorNode(BinaryTreeNode<Integer> current, int node, BinaryTreeNode<Integer> successor) {
        if (current.value == null) return null;
        if (current.value == node && current.right != null)
            return getLeftMostOfRightNode(current.right);
        else if (node < current.value) {
            successor = current;
            if (current.left != null)
                return successorNode(current.left, node, successor);
            else
                return successorNode(current.right, node, successor);
        }

        return successor;
    }

    private BinaryTreeNode<Integer> getLeftMostOfRightNode(BinaryTreeNode<Integer> node) {
        if (node.left != null) return getLeftMostOfRightNode(node.left);
        return node;
    }

    public static void main(String[] args) {
        Integer[] items = {1, 3, 7, 6, 8, 10, 10, 89, 100};
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(6);
        root.left = new BinaryTreeNode<Integer>(4);
        root.right = new BinaryTreeNode<Integer>(10);
        root.left.left = new BinaryTreeNode<Integer>(1);
        root.left.right = new BinaryTreeNode<Integer>(5);
        root.right.right = new BinaryTreeNode<Integer>(12);
        root.right.left = new BinaryTreeNode<Integer>(8);
        root.right.left.left = new BinaryTreeNode<Integer>(7);
        root.right.left.right = new BinaryTreeNode<Integer>(9);

//        BinaryTree<Integer> binaryTree = new BinaryTree<>(items);

//        BinaryTreeNode<Integer> root = binaryTree.getRoot();

        Successor successor = new Successor();
        BinaryTreeNode<Integer> snode = successor.successorNode(root, 5, null);
        System.out.println(snode.value);
    }
}
