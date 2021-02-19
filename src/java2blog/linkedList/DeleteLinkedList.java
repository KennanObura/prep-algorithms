package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class DeleteLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(5);
        A.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next = new ListNode(7);


        ListNode result2 = deleteKey(A, 1);

        System.out.println();
        while (result2 != null) {
            System.out.print(result2.val + "->");
            result2 = result2.next;
        }
    }


    private static ListNode deleteKey(ListNode head, int K){
        ListNode newHead = new ListNode(-1);

        newHead.next = head;
        ListNode prev = null;
        ListNode current = newHead;

        while (current.next != null){

            if(current.val == K){
                assert prev != null;
                prev.next = current.next;
            }
            prev = current;
            current = current.next;
        }

        if(current.val == K) {
            assert prev != null;
            prev.next = null;
        }


        return newHead.next;
    }
}
