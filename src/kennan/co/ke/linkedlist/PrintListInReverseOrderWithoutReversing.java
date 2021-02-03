package kennan.co.ke.linkedlist;

public class PrintListInReverseOrderWithoutReversing {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        printReverseOrder(head);
    }


    private static void printReverseOrder(Node current) {
        if (current == null) return;
        printReverseOrder(current.next);
        System.out.println(current.val);
    }

    private static class Node {
        Node next;
        final int val;

        Node(int val) {
            this.val = val;
        }
    }
}
