package java2blog.linkedList;


import LEETCODE.linkedList.Node.ListNode;

public class IsPalindromeRecursiveUsingString {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));

    }

    private static boolean isPalindrome(ListNode node) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        isPalindrome(node, sb1, sb2);

        return sb1.toString().equals(sb2.toString());
    }

    private static void isPalindrome(ListNode node, StringBuilder sb1, StringBuilder sb2) {
        if (node == null) return;
        sb1.append(node.val);
        isPalindrome(node.next, sb1, sb2);
        sb2.append(node.val);
    }

}
