package LEETCODE.bst;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * <p>
 * Example 1:
 * 5
 * /\
 * 3   6
 * /\     \
 * 2   4     7
 * <p>
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 */
public class TwoSumBST {
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        five.left = three;
        five.right = six;
        three.left = two;
        three.right = four;

        six.right = seven;

        System.out.println(findTarget(five, 9));


    }

    static private boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        inOrder(root, arrayList);
        System.out.println(arrayList);

        int start = 0;
        int end = arrayList.size() - 1;
        while (start < end) {
            int sum = arrayList.get(start) + arrayList.get(end);
            if (sum > k) end--;
            else if (sum < k) start++;
            else return true;
        }
        return false;
    }

    private static void inOrder(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) return;
        inOrder(root.left, arrayList);
        arrayList.add(root.val);
        inOrder(root.right, arrayList);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
