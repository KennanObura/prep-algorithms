package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

import java.util.Stack;

public class PalindromeWithStack {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> number = new SinglyLinkedList<>();
        number.add(new SinglyLinkedListNode<>(2));
        number.add(new SinglyLinkedListNode<>(3));
        number.add(new SinglyLinkedListNode<>(1));
        number.add(new SinglyLinkedListNode<>(3));
        number.add(new SinglyLinkedListNode<>(2));

        System.out.println(isPalindrome(number.getHead()));
    }

    private static boolean isPalindrome(SinglyLinkedListNode<Integer> head) {
        SinglyLinkedListNode<Integer> slow = head;
        SinglyLinkedListNode<Integer> fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.add(slow.value);
            fast = fast.next.next;
            slow = slow.next;
        }

        /*
         * Handle when List was in odd number
         */
        if (fast != null)
            slow = slow.next;


        while (slow != null && !stack.isEmpty()) {
            int value = stack.pop();
            if (value != slow.value)
                return false;
            slow = slow.next;
        }

        return true;
    }
}
