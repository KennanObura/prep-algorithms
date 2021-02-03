package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class ReverseInPairs {
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
        System.out.println(list.toString());

        SinglyLinkedListNode<Integer> result = reverse(list.getHead());

        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    private static SinglyLinkedListNode<Integer> reverse(SinglyLinkedListNode<Integer> current) {
        if (current == null || current.next == null) return current;
        /*
         * 1-> 2 -> 3 -> 4
         */
        //store second item in temp :: 2
        SinglyLinkedListNode<Integer> temp = current.next;
        //link current to next of temp :: 1 -> 3
        current.next = temp.next;
        //link temp to point to current  :: 2 -> 1
        temp.next = current;
        //recure

        current.next = reverse(current.next);

        return temp;

    }


}
