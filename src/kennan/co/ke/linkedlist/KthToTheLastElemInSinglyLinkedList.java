package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class KthToTheLastElemInSinglyLinkedList {
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

//        SinglyLinkedListNode<Integer> result = itemFromLast(list.getHead(), 3);
//        System.out.println(result.value);

        SinglyLinkedListNode<Integer> result = itemFromLastII(list.getHead(), 4);
        System.out.println(result.value);
//        print(result);
    }

    private static SinglyLinkedListNode<Integer> itemFromLast(SinglyLinkedListNode<Integer> head, int K) {
        if (head == null) return null;

        int sizeOfList = getSizeOfList(head);
        if (K > sizeOfList) return null;
        SinglyLinkedListNode<Integer> current = head;
        for (int i = 1; i <= sizeOfList - K; i++)
            current = current.next;

        return current;
    }


    private static SinglyLinkedListNode<Integer> itemFromLastII(SinglyLinkedListNode<Integer> head, int K) {
        if (head == null) return null;

        SinglyLinkedListNode<Integer> first = head;
        SinglyLinkedListNode<Integer> second = head;

        for (int i = 1; i <= K; i++)
            first = first.next;

        while (first != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }

    private static int getSizeOfList(SinglyLinkedListNode<Integer> head) {
        SinglyLinkedListNode<Integer> current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    private static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println();
    }
}
