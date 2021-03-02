package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeafTraversalOfTwoTreeIsSame {
    public static void main(String[] args) {
        TreeNode x = new TreeNode(1);
        x.left = new TreeNode(2);
        x.right = new TreeNode(3);
        x.left.left = new TreeNode(4);
        x.left.right = new TreeNode(5);
        x.right.left = new TreeNode(6);

        TreeNode y = new TreeNode(1);
        y.left = new TreeNode(2);
        y.right = new TreeNode(3);
        y.left.right = new TreeNode(4);
        y.right.left = new TreeNode(5);
//        y.right.right = new TreeNode(6);


        System.out.println(isLeafTraversalSame(x, y));


    }


    /*
    Traverse first tree and store leaf to list
    Traverse second tree and store leaf to list
    compare two lists
     */


    private static boolean isLeafTraversalSame(TreeNode A, TreeNode B) {
        LinkedList<Integer> leafListA = new LinkedList<>();
        LinkedList<Integer> leafListB = new LinkedList<>();

        inOrderTraversal(A, leafListA);

        inOrderTraversal(B, leafListB);



        return leafListA.equals(leafListB);
    }

    private static void inOrderTraversal(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null)
            list.addLast(root.val);

        inOrderTraversal(root.left, list);
        inOrderTraversal(root.right, list);
    }
}
