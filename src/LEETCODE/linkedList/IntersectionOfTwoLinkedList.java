package LEETCODE.linkedList;

/*
160. Intersection of Two Linked Lists
Easy

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
begin to intersect at node c1.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */

import LEETCODE.linkedList.Node.ListNode;

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);

        ListNode oneA = new ListNode(1);
        ListNode oneB = new ListNode(1);
        ListNode eight = new ListNode(8);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        headB.next = six;
        headA.next = oneA;
        oneA.next = eight;
        eight.next = four;
        four.next = five;

        six.next = oneB;
        oneB.next = eight;

        System.out.println(getIntersectionNode(headA, headB).val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getListSize(headA);
        int sizeB = getListSize(headB);

        ListNode big = sizeA > sizeB ? headA : headB;
        ListNode small = sizeA > sizeB ? headB : headA;
        int diff = Math.abs(sizeA - sizeB);

        while (diff > 0) {
            big = big.next;
            diff--;
        }

        while (big != null && small != null && big != small) {
            big = big.next;
            small = small.next;
        }

        return big;


    }

    private static int getListSize(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
