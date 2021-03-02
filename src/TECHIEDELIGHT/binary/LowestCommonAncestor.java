package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        root.left = two;
        root.right = three;
        root.left.right = four;
        root.right.left = five;
        root.right.right = six;
        root.right.left.left = seven;
        root.right.left.right = eight;

        System.out.println(lowestCommonAncestor(root, two, three));
    }

    /*
    Simple solution
    Traverse list in preOrder and put path from root to key in a list
    Compare the two lists
    the last common item is the LCA
    1->3->6
    1->3-> 5-> 7
     */


    private static int lowestCommonAncestor(TreeNode node, TreeNode A, TreeNode B) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();


        lowestCommonAncestor(node, A, listA);
        lowestCommonAncestor(node, B, listB);

        int i = 0;
        while (i < listA.size() && i < listB.size() && listA.get(i).equals(listB.get(i)))
            i++;
//
        System.out.println(listB);
        System.out.println(listA);
        return listA.get(i - 1);
//
//        return 0;
    }

    private static boolean lowestCommonAncestor(TreeNode node, TreeNode A, List<Integer> list) {
        if (node == null) return false;

        list.add(node.val);

        if(node == A) return true;

        boolean left = lowestCommonAncestor(node.left, A, list);
        boolean right = lowestCommonAncestor(node.right, A, list);

        if (left | right) return true;

        list.remove(list.size() - 1);
        return false;

    }
}
