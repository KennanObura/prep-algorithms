package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(head, 1);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;


        /*
        Have two pointers, low, high
        move high till n

        Have another pointer prev
        move all pointers till high == null
        low will be at the nth position from back
        using prev, remove low
        prev.next = low.next
       n= 2
       1-> 2->3->5->6->8

         */

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode low = temp, high = temp;

        for (int i = 0; i < n; i++)
            high = high.next;


        while (high != null && high.next != null) {
            low = low.next;
            high = high.next;
        }

        low.next = low.next.next;

        return temp.next;
    }
}
