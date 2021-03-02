package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;
/*
82. Remove Duplicates from Sorted List II
Medium
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.


Example 1:

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]

 */

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(1);
        A.next.next.next = new ListNode(1);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(5);

        ListNode result = deleteDuplicates(A);
        while (result != null) {
            System.out.print(result.val + " ->");
            result = result.next;
        }

    }



    private static ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//
//        return deleteDuplicatesUtil(current);
        return head;
    }

//    private static ListNode deleteDuplicatesUtil(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        if (head.val != head.next.val) {
//            head.next = deleteDuplicatesUtil(head.next);
//            return head;
//        }
//
//        ListNode cur = head;
//
//
//        while (cur.val == cur.next.val)
//            cur = cur.next;
//
//        return deleteDuplicatesUtil(cur);
//    }
}
