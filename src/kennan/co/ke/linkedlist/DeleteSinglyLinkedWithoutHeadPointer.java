package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class DeleteSinglyLinkedWithoutHeadPointer {
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

        SinglyLinkedListNode<Integer> result = delete(list.getHead(), five);
        System.out.println("Printing result");
        print(result);
    }

    private static SinglyLinkedListNode<Integer> delete(SinglyLinkedListNode<Integer> head, SinglyLinkedListNode<Integer> node) {
        if(node.next == null)
            return node;

        node.value = node.next.value;
        node.next = node.next.next;
        System.gc();
        return head;
    }

    private static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
