package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;
import LEETCODE.tree.treeclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);

        TreeNode treeNode = sortedListToBST(A);

        inOrder(treeNode);
        System.out.println();
        preOrder(treeNode);

    }

    private static void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }


    private static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val);
        inOrder(root.left);
        inOrder(root.right);
    }


    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> list = convertToList(head);

        return sortedListToBST(list, 0, list.size() - 1);
    }

    private static List<Integer> convertToList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }


    public static TreeNode sortedListToBST(List<Integer> nodes, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nodes.get(mid));

        root.left = sortedListToBST(nodes, start, mid - 1);
        root.right = sortedListToBST(nodes, mid + 1, end);

        return root;
    }
}
