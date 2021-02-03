package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

/**
 * In Binary Tree, Lowest Common Ancestor of n1 and n2 is the immediate shared node by the two
 * <p>
 * 35
 * /  \
 * 14     8
 * / \
 * 12    4
 * <p>
 * lca(14, 35) = 35
 * lca(12, 4) = 14
 * lca(14, 8) = 35
 * <p>
 * Algorithm
 * <p>
 * SOLUTION I
 * Let nodes be n, m
 * Recursively traverse tree,
 * if( any n|| m == root) return root --> LCA
 * recursively look in  left subtree
 * recursively look in right subtree
 * <p>
 * if both left && right not null, means root is the LCA,
 * <p>
 * else return any thats not null
 */

public class LowestCommonAncestorOfNormalBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(35);
        root.left = new BinaryTreeNode<>(14);
        root.right = new BinaryTreeNode<>(8);
        root.left.left = new BinaryTreeNode<>(12);
        root.left.right = new BinaryTreeNode<>(4);

        System.out.println(findLowestCommonAncestor(root, 12, 4).value);
    }

    private static BinaryTreeNode<Integer> findLowestCommonAncestor(BinaryTreeNode<Integer> root, int n, int m) {
        if (root == null) return null;

        if (root.value == n || root.value == m) return root; //root is the lca eg lca(14, 35) = 35

        BinaryTreeNode<Integer> left = findLowestCommonAncestor(root.left, n, m);
        BinaryTreeNode<Integer> right = findLowestCommonAncestor(root.right, n, m);

        if (left != null && right != null) return root;

        return (left != null ? left : right);
    }

}
