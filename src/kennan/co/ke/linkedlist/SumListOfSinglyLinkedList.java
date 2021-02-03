package kennan.co.ke.linkedlist;

import kennan.co.ke.linkedlist.base.SinglyLinkedList;
import kennan.co.ke.linkedlist.base.SinglyLinkedListNode;

public class SumListOfSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<>(2);
        SinglyLinkedListNode<Integer> three = new SinglyLinkedListNode<>(3);
        SinglyLinkedListNode<Integer> four = new SinglyLinkedListNode<>(4);
        SinglyLinkedListNode<Integer> five = new SinglyLinkedListNode<>(5);
        SinglyLinkedListNode<Integer> six = new SinglyLinkedListNode<>(6);
        SinglyLinkedListNode<Integer> one = new SinglyLinkedListNode<>(1);
        SinglyLinkedListNode<Integer> seven = new SinglyLinkedListNode<>(7);
        SinglyLinkedListNode<Integer> nine = new SinglyLinkedListNode<>(9);

        SinglyLinkedList<Integer> number1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> number2 = new SinglyLinkedList<>();
        number1.add(seven);
        number1.add(one);
        number1.add(six);

        number2.add(five);
        number2.add(nine);
        number2.add(two);
        number2.add(three);

        print(number1.getHead());
        print(number2.getHead());
        SinglyLinkedListNode<Integer> result = addLists(number1.getHead(), number2.getHead());
        print(result);

    }

    private static SinglyLinkedListNode<Integer> addLists(SinglyLinkedListNode<Integer> number1, SinglyLinkedListNode<Integer> number2) {
        if (number1 == null) return number2;
        if (number2 == null) return number1;

        SinglyLinkedListNode<Integer> resultHead = null;
        SinglyLinkedListNode<Integer> result = null;
        int remainder = 0;

        while (number1 != null && number2 != null) {
            int sum = number1.value + number2.value + remainder;
            if (sum > 9) {
                remainder = sum / 10;
                sum = sum % 10;
            } else remainder = 0;


            SinglyLinkedListNode<Integer> temp = new SinglyLinkedListNode<>(sum);

            if (resultHead == null) {
                result = temp;
                resultHead = temp;
            } else {
                result.next = temp;
                result = temp;
            }

            number1 = number1.next;
            number2 = number2.next;
        }

        while (number1 != null) {
            result.next = new SinglyLinkedListNode<>(number1.value + remainder);
            number1 = number1.next;
        }

        while (number2 != null) {
            result.next = new SinglyLinkedListNode<>(number2.value + remainder);
            number2 = number2.next;
        }
        return resultHead;
    }

    private static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.print(current.value + " ->");
            current = current.next;
        }
        System.out.println();
    }

}
