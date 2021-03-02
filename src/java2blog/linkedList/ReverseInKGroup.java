package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class ReverseInKGroup {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next.next = new ListNode(7);


        ListNode result = reverseInK(A, 2);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }


    private static ListNode reverseInK(ListNode node, int K) {
        if (node == null || node.next == null) return node;

        //reverse k
        int i = 0;
        ListNode next = null, prev = null;
        ListNode current = node;
        while (i < K && current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        if (next != null)
            node.next = reverseInK(next, K);

        return prev;
    }
}
