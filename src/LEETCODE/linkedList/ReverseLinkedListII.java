package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 92. Reverse Linked List II
 * Medium
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(5);
        A.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next = new ListNode(7);

        ListNode result = reverseBetween(A, 2, 3);
        while (result != null) {
            System.out.print(result.val + " ->");
            result = result.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode current = head;

        n -=m;
        while (current != null && m >= 0) {
            current = current.next;
            m--;
        }

//        ListNode left = head;

        System.out.println(n);
        ListNode prev = null, next = null;
        while (current != null && n >= 0) {
            next = current.next;
            current.next = prev;

            /*
             * Advance nodes
             */
            prev = current;
            current = next;
            n--;
        }



        return head;

    }
}
