package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class FindStartNodeOfLoop {
    public static void main(String[] args) {

        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next = B;
        B.next = C;
        C.next = A;
//        C.next.next = D;
//        D.next = E;
//        C.next = new ListNode(12);
//        C.next.next = B;
//        C.next.next.next = new ListNode(33);
//        C.next.next.next.next = new ListNode(14);


        System.out.println(findStartNodeOfLoop(A));
    }

    private static ListNode findStartNodeOfLoop(ListNode head) {
        /*
        1. Use slow, fast pointers to detect loop.
            if no loop
                -> null
            else
                adjust fast to head

                traverse while fast != slow
                return meeting point
         */

        boolean loopDetected = false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                loopDetected = true;
                break;
            }
        }

        if (!loopDetected) return null;


        slow = head;

        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        return slow;
    }


}
