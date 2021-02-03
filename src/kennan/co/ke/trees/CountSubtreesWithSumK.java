package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

public class CountSubtreesWithSumK {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(4);
        root.left = new BinaryTreeNode<Integer>(5);
        root.right = new BinaryTreeNode<Integer>(-2);
        root.left.left = new BinaryTreeNode<Integer>(-1);
        root.left.right = new BinaryTreeNode<Integer>(2);
        root.right.right = new BinaryTreeNode<Integer>(5);
        root.right.left = new BinaryTreeNode<Integer>(8);
        root.right.left.left = new BinaryTreeNode<Integer>(7);
        root.right.left.right = new BinaryTreeNode<Integer>(-9);


        Pair subtrees = countSubTrees(root,  6);
        System.out.println(subtrees.count);
    }

    private static Pair countSubTrees(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return new Pair(0, 0);

        Pair leftSum = countSubTrees(root.left, target);
        Pair rightSum = countSubTrees(root.right, target);

        int sum = leftSum.sum + rightSum.sum + root.value;
        int count = leftSum.count + rightSum.count;
        System.out.println(sum);
        if (sum == target)
            count++;
        return new Pair(sum, count);
    }

    private static class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
