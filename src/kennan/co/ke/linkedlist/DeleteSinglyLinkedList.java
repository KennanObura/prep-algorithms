package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class DeleteSinglyLinkedList {
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
        list.add(six);

        print(list.getHead());

        SinglyLinkedListNode<Integer> result = delete(list.getHead(), two);
        System.out.println("Printing result");
        print(result);
    }

    private static SinglyLinkedListNode<Integer> delete(SinglyLinkedListNode<Integer> head, SinglyLinkedListNode<Integer> node) {
        if(head == node){
            head = head.next;
            return head;
        }

        SinglyLinkedListNode<Integer> prev = null;
        SinglyLinkedListNode<Integer> current = head;

        while (current != null) {
            if (current == node) {
                prev.next = current.next;
                System.out.println("found");
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    private static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
