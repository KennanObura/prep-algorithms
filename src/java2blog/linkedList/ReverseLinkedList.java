package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);

//        ListNode result = reverseList(A);

        ListNode result = reverseListRecursive(A);

        while (result != null) {
            System.out.print(result.val + " ->");
            result = result.next;
        }
    }

    private static ListNode reverseList(ListNode node) {
        if (node == null) return null;

        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    private static ListNode reverseListRecursive(ListNode node) {


        /**
         * If it is the last node/ only node or Null
         */
        if (node == null || node.next == null) return node;

        ListNode newNode = reverseListRecursive(node.next);

        /**
         *
         * Reverse at the tail
         */
        node.next.next = node;
        node.next = null;
        return newNode;
    }
}
