package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class RemoveDuplicateFromSorted {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);


        ListNode res = removeDuplicates(head);

        while (res != null){
            System.out.print(res.val + " -");
            res = res.next;
        }
//
    }

    static ListNode  removeDuplicates(ListNode node){
        if(node == null || node.next == null) return node;


        ListNode current = node;
        ListNode pre = null;

        while (current != null) {
            if(pre != null && pre.val == current.val)
                pre.next = current.next;
            pre = current;
            current = current.next;
        }

//        if(pre != null && pre.val == current.val)
//            pre.next = null;

        return node;
    }
}
