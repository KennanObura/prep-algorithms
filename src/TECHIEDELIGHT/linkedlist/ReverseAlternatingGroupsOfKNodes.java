package TECHIEDELIGHT.linkedlist;

import LEETCODE.linkedList.Node.ListNode;

public class ReverseAlternatingGroupsOfKNodes {
    private static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        print(reverseKGroup(head, 3));

    }


    private  static ListNode reverseKGroup(ListNode node, int K) {

        if(node == null) return null;
        ListNode current = node;
        for (int i = 1; current.next != null && i < K; i++) {
            current = current.next;
        }

        ListNode temp = current.next;
        current.next = null;
        print(node);
        ListNode reversed = reverseList(node);

        System.out.println("printing reversed");
        print(reversed);

        /*
        Advance reversed to tail
         */

        reversed.next = temp;
        print(temp);
        ListNode u = reverseKGroup(temp, K);
        return current;
    }


    private static void print(ListNode current) {
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();
    }

    private static ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode current = node, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        /*
        Return tail instead of the current head
        after reversal, take is the prev head (node in this case)
         */
        return node;
    }
}
