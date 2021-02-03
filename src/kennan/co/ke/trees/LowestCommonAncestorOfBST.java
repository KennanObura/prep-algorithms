package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

/**
 * In Binary Tree, Lowest Common Ancestor of n1 and n2 is the immediate shared node by the two
 * <p>
 * 6
 * /  \
 * 4     8
 * / \
 * 2    5
 * <p>
 * lca(2, 5) = 4
 * lca(4, 6) = 6
 * lca(2, 8) = 6
 * <p>
 * Algorithm
 * <p>
 *     SOLUTION I
 * Recursively traverse tree,
 * if both nodes are less than root node, then lca lies to the left, -> go left
 * if both are more, go right
 * else both fails, the root is the lca, return it
 *
 *  NOTE:
 *      The recusrive call takes up o(h) space for recursion calls
 *      We can avoid using space by implementing iteratively
 *  SOLUTION II : Iteration
 *
 */

public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(6);
        root.left = new BinaryTreeNode<>(4);
        root.right = new BinaryTreeNode<>(8);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(5);

        System.out.println(findLowestCommonAncestor(root, 2, 5).value);

        System.out.println(findLowestCommonAncestorIterative(root, 2, 5).value);
    }

    private static BinaryTreeNode<Integer> findLowestCommonAncestorIterative(BinaryTreeNode<Integer> root, int n, int m) {

        while (root != null) {
            if (root.value > n && root.value > m)
                root = root.left;
            if (root.value < n && root.value < m)
                root = root.right;
            else //both fails, just return the node
                break;
        }
        return root;
    }

    // o(logn) ====> o(h) where h is the height of tree
    private static BinaryTreeNode<Integer> findLowestCommonAncestor(BinaryTreeNode<Integer> node, int n, int m) {
        if (node == null) return null;
        if (node.value > n && node.value > m) //traverse left
            return findLowestCommonAncestor(node.left, n, m);
        else if (node.value < n && node.value < m) //traverse right
            return findLowestCommonAncestor(node.right, n, m);
        else return node;
    }
}
