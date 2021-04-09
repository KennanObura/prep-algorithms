package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 86. Partition List
 * Medium
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 * <p>
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(4);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(2);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(2);


        ListNode result = partition(A, 3);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smaller = new ListNode(-1);
        ListNode smallerTail = smaller;
        ListNode greater = new ListNode(-1);
        ListNode greaterTail = greater;

        while (head != null) {
            if (head.val < x) {
                smallerTail.next = new ListNode(head.val);
                smallerTail = smallerTail.next;
            } else {
                greaterTail.next = new ListNode(head.val);
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }

        smallerTail.next = greater.next;
        return smaller.next;
    }
}
