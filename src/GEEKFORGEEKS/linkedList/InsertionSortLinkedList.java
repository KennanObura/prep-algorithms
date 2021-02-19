package GEEKFORGEEKS.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class InsertionSortLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(11);
        A.next = new ListNode(11);
        A.next.next = new ListNode(13);
//        A.next.next.next = new ListNode(5);
//        A.next.next.next.next = new ListNode(1);
//        A.next.next.next.next.next = new ListNode(4);
//        A.next.next.next.next.next.next = new ListNode(14);

        insertionSort(A);

        ListNode sorted = sortedListHead;
        while (sorted != null) {
            System.out.print(sorted.val + " ->");
            sorted = sorted.next;
        }
    }


    private static void insertionSort(ListNode node) {

        while (node != null) {
            sortedList(node.val);
            node = node.next;
        }
    }

    private static ListNode sortedListHead = null;

    private static void sortedList(int value) {
        ListNode newNode = new ListNode(value);

        if (sortedListHead == null) {
            sortedListHead = newNode;
            return;
        }

        if (value < sortedListHead.val) {
            newNode.next = sortedListHead;
            sortedListHead = newNode;
            return;
        }

        ListNode current = sortedListHead;
        ListNode prev = null;

        while (current != null && current.val <= value) {
            prev = current;
            current = current.next;
        }

        prev.next = newNode;
        if (current != null)
            newNode.next = current;

    }

}
