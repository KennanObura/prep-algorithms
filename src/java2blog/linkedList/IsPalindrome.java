package java2blog.linkedList;


import LEETCODE.linkedList.Node.ListNode;

public class IsPalindrome {
    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));

    }

    static ListNode temp;
    private static boolean isPalindrome(ListNode node) {
         temp = head;
        if (node == null) return true;

        boolean res = isPalindrome(node.next);
        if (!res) return false;

        boolean result = (temp.val == node.val);

        /* Move left to next node */
        temp = temp.next;

        return result;

    }

}
