package TECHIEDELIGHT.linkedlist;

import LEETCODE.linkedList.Node.ListNode;

import java.util.Stack;

/**
 * https://www.techiedelight.com/add-single-digit-number-linked-list-representing-number/
 * <p>
 * Example 9->9->9->3    and 7
 * <p>
 * Output
 * 1->0->0->0->0
 */

/*
IDEA 1
Put list into stack
empty stack,
while popping off from stack, add and  create another list


IDEA 2
reverse whole list
Traverse list while adding
finally reverse the list again to its origin
 */
public class AddSingleDigitNumberUsingReversal {
    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        A.next = new ListNode(2);
        A.next.next = new ListNode(2);
//        A.next.next.next = new ListNode(9);
//        A.next.next.next.next = new ListNode(9);
//        A.next.next.next.next.next = new ListNode(9);

        ListNode result = addSingleDig(A, 2);
        print(result);


    }

    private static void print(ListNode node) {
        ListNode result = node;
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

    private static ListNode addSingleDig(ListNode node, int num) {
       /*
       - reverse list
       - travese reversed and add dig + curry
       - reverse back
       return
        */

        ListNode reverseOriginal = reverseList(node);
        print(reverseOriginal);
        int curry = num;
        ListNode current = reverseOriginal;
        while (curry > 0) {
            int val = current.val + curry;
            curry = val / 10;
            current.val = val % 10;
            if(current.next == null)
                break;
            current = current.next;
        }
        if ( curry > 0) {
            current.next = new ListNode(curry);
        }


        print(reverseOriginal);

        return reverseList(reverseOriginal);
    }

    private static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode current = node;
        ListNode next = null;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }


}
