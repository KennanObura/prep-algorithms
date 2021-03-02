package java2blog.bst;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.left.left.right.left = new TreeNode(12);
        root.left.left.right.right = new TreeNode(13);
        root.right.right.left.left = new TreeNode(14);

        System.out.println(boundaryTraversal(root));

    }


    static ArrayList<Integer> boundaryTraversal(TreeNode root) {
        /*
        Maintain 3 lists
            left -> top-down
            left
            right -> bottom-up
        Traverse left in postorder
         */

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> leafList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        leftList.add(root.val);
        traverseLeft(root.left, leftList);
        traverseLeaf(root, leafList);
        traverseRight(root.right, rightList);


        leftList.addAll(leafList);
        leftList.addAll(rightList);

        return leftList;
    }

    private static void traverseRight(TreeNode root, ArrayList<Integer> list) {
        if (root == null || isLeaf(root)) return;
        traverseRight(root.right != null ? root.right : root.left, list);
        list.add(root.val);
    }


    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void traverseLeaf(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        traverseLeft(root.left, list);
        if (isLeaf(root)) {
            list.add(root.val);
        }
        traverseLeaf(root.right, list);
    }

    private static void traverseLeft(TreeNode root, ArrayList<Integer> list) {
        if (root == null || isLeaf(root)) return;
        list.add(root.val);
        traverseLeft(root.left != null ? root.left : root.right, list);
    }
}


