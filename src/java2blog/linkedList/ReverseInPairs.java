package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class ReverseInPairs {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);

//        ListNode result = reverseInPairs(A);
//
//        while (result != null) {
//            System.out.print(result.val + "->");
//            result = result.next;
//        }


        ListNode result2 = reverseInPairs(A);

        System.out.println();
        while (result2 != null) {
            System.out.print(result2.val + "->");
            result2 = result2.next;
        }
    }

    private static ListNode reverseInPairs(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode temp = null;
        ListNode current = node;
        ListNode result = null;
        while (current != null && current.next != null) {
            if (temp != null)
                temp.next.next = current.next;

            temp = current.next;
            current.next = temp.next;
            temp.next = current;

            if (result == null)
                result = temp;
            current = current.next;
        }
        return result;
    }


    private static ListNode reverseInPairsRecursive(ListNode current) {
        if (current == null || current.next == null) return current;

        ListNode temp = current.next;
        current.next = temp.next;
        temp.next = current;
        current.next = reverseInPairsRecursive(current.next);
        return temp;
    }

}
