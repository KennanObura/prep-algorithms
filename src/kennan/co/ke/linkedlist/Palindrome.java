package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.PrintList;
import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class Palindrome {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> number = new SinglyLinkedList<>();
        number.add(new SinglyLinkedListNode<>(2));
        number.add(new SinglyLinkedListNode<>(3));
//        number.add(new SinglyLinkedListNode<>(1));
        number.add(new SinglyLinkedListNode<>(3));
        number.add(new SinglyLinkedListNode<>(2));

        System.out.println(isPalindrome(number.getHead()));
    }

    private static boolean isPalindrome(SinglyLinkedListNode<Integer> head) {
        SinglyLinkedListNode<Integer> mid = getMidNode(head);
        SinglyLinkedListNode<Integer> temp = reverseList(mid.next);

        mid.next = null;
//        PrintList.print(head);
        return isPalindrome(head, temp);
    }

    private static boolean isPalindrome(SinglyLinkedListNode<Integer> head, SinglyLinkedListNode<Integer> temp) {
        while (head != null && temp != null) {
            if (!head.value.equals(temp.value))
                return false;
            System.out.println(head.value + "h");
            System.out.println(temp.value + "t");
            head = head.next;
            temp = temp.next;
        }
        return (temp == null);
    }

    private static SinglyLinkedListNode<Integer> reverseList(SinglyLinkedListNode<Integer> node) {
        SinglyLinkedListNode<Integer> prev = null;
        SinglyLinkedListNode<Integer> next = null;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private static SinglyLinkedListNode<Integer> getMidNode(SinglyLinkedListNode<Integer> head) {
        SinglyLinkedListNode<Integer> slow = head;
        SinglyLinkedListNode<Integer> fast = head;

        while (fast != null) {
            fast = fast.next;

            if (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }


}
