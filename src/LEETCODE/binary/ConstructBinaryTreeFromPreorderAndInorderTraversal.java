package LEETCODE.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary
 * tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * Example 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7}, in = {9, 3, 15, 20, 7};

        int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};

        TreeNode result = buildTree(pre, in);

        TreeNode result2 = buildTree(preorder, inorder);

        printPreOrder(result);
        System.out.println("================");
        printPreOrder(result2);

    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        - Start with the first elem from preorder and make it root
        - Lookup for its index in inorder (In inorder, all elems before such index will form the left tree, and all after such
        index will form the right tree)
        - recur to construct left
        - recur to construct right

        let construct(i, j) be function to construct tree
            such that i is first index in pre order
            and j is end of pre order

        let root node be pre[start]

        let k be index of p[i] in inorder

        root.left = construct(i, k-1)
        root.right = construct(k+1, j)


         */

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return buildTree(preorder, 0, preorder.length - 1, 0, map);
    }





    private static TreeNode buildTree(int[] preorder, int start, int end, int i, Map<Integer, Integer> map) {
        if (start > end || i > end) return null;

        TreeNode root = new TreeNode(preorder[i++]);

        /*
        This node has no children/ is leaf
         */
        if (start == end) return root;

        int j = map.get(root.val);

        root.left = buildTree(preorder, start, j - 1, i, map);
        root.right = buildTree(preorder, j + 1, end, i, map);

        return root;
    }




    private static void printPreOrder(TreeNode node) {
        if (node == null) return;


        printPreOrder(node.left);
        System.out.println(node.val);
        printPreOrder(node.right);
    }
}
