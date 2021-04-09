package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * Hard
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * Follow up:
 * <p>
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * Example 3:
 * <p>
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 * Example 4:
 * <p>
 * Input: head = [1], k = 1
 * Output: [1]
 */

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseKGroup(head, 3);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head; //if this is the last node, or null

        ListNode current = head;
        ListNode next = null, prev = null;
        int z = k;

        while (z > 0 && current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            z--;
        }


        head.next = reverseKGroup(next, k); // make next head of the remaining part
        return prev;

    }
}
