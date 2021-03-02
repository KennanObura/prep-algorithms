package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

import java.util.List;

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
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next = new ListNode(7);
        A.next.next.next.next.next.next = new ListNode(8);
        A.next.next.next.next.next.next.next = new ListNode(10);

        ListNode result = reverseBetween(A, 2, 6);
        while (result != null) {
            System.out.print(result.val + " ->");
            result = result.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        /*
        - let cur be the current node
                prev -> prev of cur node
                next -> next of cur node

          traverse with prev & cur till m

          - copy prev in temp

          - traverse till m
                reverse

          - point next of temp to prev
         */

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null && m > 0) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode temp = prev;
        ListNode tail = cur;  // temp and tail will fix the list
        ListNode next = null;

        while (cur != null && cur.next != null && n > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        }

        if (temp != null)
            temp.next = prev;
        else head = prev;

        tail.next = cur;

        return head;

    }
}
