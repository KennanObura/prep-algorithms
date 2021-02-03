package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class PartitionSinglyLinkedListAroundX {
    public static void main(String[] args) {
        SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<>(2);
        SinglyLinkedListNode<Integer> three = new SinglyLinkedListNode<>(3);
        SinglyLinkedListNode<Integer> four = new SinglyLinkedListNode<>(4);
        SinglyLinkedListNode<Integer> five = new SinglyLinkedListNode<>(5);
        SinglyLinkedListNode<Integer> six = new SinglyLinkedListNode<>(6);
        SinglyLinkedListNode<Integer> one = new SinglyLinkedListNode<>(1);

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(two);
        list.add(five);
        list.add(three);
        list.add(four);
        list.add(six);
        list.add(one);

        print(list.getHead());

        SinglyLinkedListNode<Integer> result = partition(list.getHead(), 5);
        System.out.println("Printing partitioned result");
        print(result);
    }

    private static SinglyLinkedListNode<Integer> partition(SinglyLinkedListNode<Integer> current, int K) {
        /*
         * Maintain two lists :: lessThanList, moreThanList.
         * On iteration , if node is less, attach to lessThanList,
         * Marge the two lists
         */

        SinglyLinkedListNode<Integer> lessThanList = null;
        SinglyLinkedListNode<Integer> moreThanList = null;
        SinglyLinkedListNode<Integer> lessThanHead = null;
        SinglyLinkedListNode<Integer> moreThanHead = null;

        while (current != null) {
            SinglyLinkedListNode<Integer> next = current.next;
            if (current.value < K) {
                if (lessThanHead == null)
                    lessThanHead = current;
                lessThanList = attachToNext(lessThanList, current);
//                System.out.println(lessThanList.value + "---");
            } else {
                if(moreThanHead == null)
                    moreThanHead = current;
                moreThanList = attachToNext(moreThanList, current);
                System.out.println(current.value + "---");
            }

            current = next;
        }

//        if (lessThanList != null)
//            lessThanList.next = moreThanHead;
        return moreThanHead;
    }

    private static SinglyLinkedListNode<Integer> attachToNext(SinglyLinkedListNode<Integer> head, SinglyLinkedListNode<Integer> node) {
        if (head == null) return node;
        head.next = node;
        return head.next;
    }


    private static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.print(current.value + " ->");
            current = current.next;
        }
        System.out.println();
    }
}
