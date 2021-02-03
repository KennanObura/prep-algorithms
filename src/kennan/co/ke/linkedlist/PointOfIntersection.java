package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PointOfIntersection {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> number = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> number2 = new SinglyLinkedList<>();

        SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<>(2);
        SinglyLinkedListNode<Integer> three = new SinglyLinkedListNode<>(3);
        SinglyLinkedListNode<Integer> four = new SinglyLinkedListNode<>(4);
        SinglyLinkedListNode<Integer> five = new SinglyLinkedListNode<>(5);
        SinglyLinkedListNode<Integer> six = new SinglyLinkedListNode<>(6);
        SinglyLinkedListNode<Integer> one = new SinglyLinkedListNode<>(1);
        SinglyLinkedListNode<Integer> seven = new SinglyLinkedListNode<>(7);
        SinglyLinkedListNode<Integer> nine = new SinglyLinkedListNode<>(9);

        number.add(three);
        number.add(two);
        number.add(seven);
        number.add(one);
        number.add(nine);

        number2.add(five);
        number2.add(four);
        number2.add(six);
        number2.add(seven);
        number2.add(one);
        number2.add(nine);

        System.out.println(intersect(number.getHead(), number2.getHead()));
    }

    private static boolean intersect(SinglyLinkedListNode<Integer> head1, SinglyLinkedListNode<Integer> head2) {

        Set<SinglyLinkedListNode<Integer>> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (set.contains(head2)){
                System.out.println("Intersect as " + head2.value);
                return true;
            }
            head2 = head2.next;
        }


        return false;
    }


}
