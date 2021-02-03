package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 */
public class SuccessorII {


    public static void main(String[] args) {
        Integer[] items = {1, 3, 7, 6, 8, 10, 10, 89, 100};
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(6);
        root.left = new BinaryTreeNode<>(4);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(12);
        root.right.left = new BinaryTreeNode<>(8);
        root.right.left.left = new BinaryTreeNode<>(7);
        root.right.left.right = new BinaryTreeNode<>(9);

        SuccessorII successor = new SuccessorII();
        BinaryTreeNode<Integer> snode = successor.successorNode(root, 6);
        System.out.println(snode.value);
    }

    private BinaryTreeNode<Integer> successorNode(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        BinaryTreeNode<Integer> targetNode = findTargetNode(root, target);

        if (targetNode != null && targetNode.right != null) {
            return leftMostNodeOfRightSubTree(targetNode.right);
        } else
            return justGreaterNode(root, target, null);
    }

    private BinaryTreeNode<Integer> justGreaterNode(BinaryTreeNode<Integer> root, int target, BinaryTreeNode<Integer> successor) {
        if (root == null) return successor;
        if (target < root.value)
            return justGreaterNode(root.left, target, root);
        else
            return justGreaterNode(root.right, target, successor);
    }

    private BinaryTreeNode<Integer> leftMostNodeOfRightSubTree(BinaryTreeNode<Integer> targetNode) {
        if (targetNode.left != null)
            return leftMostNodeOfRightSubTree(targetNode.left);
        return targetNode;
    }

    private BinaryTreeNode<Integer> findTargetNode(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;
        else if (root.value == target)
            return root;
        else if (root.left != null)
            return findTargetNode(root.left, target);
        else
            return findTargetNode(root.right, target);
    }
}
