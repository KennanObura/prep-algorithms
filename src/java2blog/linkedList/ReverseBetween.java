package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 92. Reverse Linked List II
 * Medium
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);


        ListNode result = reverseBetween(head, 3, 4);
        while (result != null) {
            System.out.print(result.val + " ->");
            result = result.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        while (current != null && m > 1){
            current = current.next;
            m--;
            n--;
        }

        ListNode toReverse = current.next;
        ListNode tail = toReverse;
        while (tail != null && n > 0){
            tail = tail.next;
            n--;
        }

        ListNode last = tail.next;
        tail.next = null;


        ListNode reversed = reverseSection(toReverse, n);
        current.next = reversed;
        reversed.next = last;


        return head;
    }

    private static ListNode reverseSection(ListNode head, int n) {
        if(head == null || head.next == null || n == 1) return head;

        ListNode temp = reverseSection(head.next, n-1);

        ListNode next = head.next;
        next.next = head;
        head.next = null;

        return temp;
    }
}
