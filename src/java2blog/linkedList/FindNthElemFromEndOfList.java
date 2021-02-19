package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class FindNthElemFromEndOfList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(5);
        A.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next = new ListNode(7);

        System.out.println(findNthElem(A, 4).val);

    }

    private static ListNode findNthElem(ListNode node, int N) {

        ListNode low = node;
        ListNode high = node;

        while (high != null) {
            if (N <= 0)
                low = low.next;
            high = high.next;
            N--;
        }

        return low;
    }
}
