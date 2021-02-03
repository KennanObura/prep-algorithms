package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. Create two pointers, FastPointer and SlowPointer.
 * 2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
 * 3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
 * 4. Move SlowPointer and FastPointer at a·rate of one step. Return the new collision point.
 */
public class DetectLoop {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> number = new SinglyLinkedList<>();


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
        number.add(four);
        number.add(two);

        System.out.println(hasLoop(number.getHead()));
    }

    private static boolean hasLoop(SinglyLinkedListNode<Integer> head) {
        SinglyLinkedListNode<Integer> fast = head;
        SinglyLinkedListNode<Integer> slow = head;

        boolean hasCollided = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                System.out.println("Nodes meet at " + slow.value );
                hasCollided = true;
                break;
            }
        }

        if(hasCollided){
            slow = head;

            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            System.out.println(slow.value);
        }
        return hasCollided;
    }


}
