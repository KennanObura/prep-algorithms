package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<>(2);
        SinglyLinkedListNode<Integer> three = new SinglyLinkedListNode<>(3);
        SinglyLinkedListNode<Integer> four = new SinglyLinkedListNode<>(4);
        SinglyLinkedListNode<Integer> five = new SinglyLinkedListNode<>(5);
        SinglyLinkedListNode<Integer> six = new SinglyLinkedListNode<>(6);

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(two);
        list.add(three);
        list.add(five);
        list.add(four);
        list.add(six);
        System.out.println(list.toString());

        SinglyLinkedListNode<Integer> result = reverseRecur(list.getHead(), null);

        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    private static SinglyLinkedListNode<Integer> reverse(SinglyLinkedListNode<Integer> head) {
        SinglyLinkedListNode<Integer> prev = null;
        SinglyLinkedListNode<Integer> next = null;
        SinglyLinkedListNode<Integer> current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }


    private static SinglyLinkedListNode<Integer> reverseRecur(SinglyLinkedListNode<Integer> current, SinglyLinkedListNode<Integer> prev) {
        if (current == null) return prev;
        SinglyLinkedListNode<Integer> next = current.next;
        current.next = prev;
        return reverseRecur(next, current);
    }

}
