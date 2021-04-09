package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 1721. Swapping Nodes in a Linked List
 * Medium
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 * <p>
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * Example 3:
 * <p>
 * Input: head = [1], k = 1
 * Output: [1]
 * Example 4:
 * <p>
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 * Example 5:
 * <p>
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 */
public class SwappingNodesInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode result = swapNodes(head, 2);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode swapNodes(ListNode head, int k) {

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode low = temp, high = temp;

        while (k > 0) {
            high = high.next;
            k--;
        }

        ListNode first = high;

        while (high.next != null) {
            low = low.next;
            high = high.next;
        }
        int tempVal = first.val;


        first.val = low.next.val;
        low.next.val = tempVal;


        return temp.next;

    }
}
