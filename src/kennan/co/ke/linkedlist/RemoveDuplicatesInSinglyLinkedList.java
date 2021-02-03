package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<>(2);
        SinglyLinkedListNode<Integer> three = new SinglyLinkedListNode<>(3);
        SinglyLinkedListNode<Integer> four = new SinglyLinkedListNode<>(4);
        SinglyLinkedListNode<Integer> five = new SinglyLinkedListNode<>(5);
        SinglyLinkedListNode<Integer> six = new SinglyLinkedListNode<>(6);

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(new SinglyLinkedListNode<>(2));
        list.add(new SinglyLinkedListNode<>(3));
        list.add(six);
        list.add(new SinglyLinkedListNode<>(6));

        print(list.getHead());

        SinglyLinkedListNode<Integer> result = removeDuplicates(list.getHead());
        System.out.println("Printing result");
        print(result);
    }

    private static SinglyLinkedListNode<Integer> removeDuplicates(SinglyLinkedListNode<Integer> head) {
        if(head == null) return null;
        Set<Integer> set = new HashSet<>();
        SinglyLinkedListNode<Integer> current = head;
        SinglyLinkedListNode<Integer> prev = new SinglyLinkedListNode<>(-1);
        prev.next = current;
        current = prev;

        while (current != null){
            if(set.contains(current.value))
                current = removeDuplicates(prev, current);
            else set.add(current.value);
            prev = current;
            current = current.next;
        }
        return head;
    }

    private static SinglyLinkedListNode<Integer> removeDuplicates(SinglyLinkedListNode<Integer> prev, SinglyLinkedListNode<Integer> current) {
        prev.next = current.next;
        return prev;
    }

    private static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
