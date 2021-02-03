package kennan.co.ke.linkedlist;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class PartitionAroundX {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        int K = 5;
        Node partitioned = partition(head, K);

        while (partitioned != null) {
            System.out.print(partitioned.val + "-> ");
            partitioned = partitioned.next;
        }

    }

    private static Node partition(Node head, int k) {
        Node beforeHead = new Node(-1);
        Node beforeTail = beforeHead;
        Node afterHead = new Node(-1);
        Node afterTail = afterHead;

        Node current = head;

        while (current != null) {
            Node next = current.next;
            if (current.val < k) {
                beforeTail.next = current;
                beforeTail = beforeTail.next;
            } else {
                afterTail.next = current;
                afterTail = afterTail.next;
            }
            current.next = null;
            current = next;
        }

        if (afterHead.next != null)
            beforeTail.next = afterHead.next;
        return beforeHead.next;

    }

    private static class Node {
        Node next;
        final int val;

        Node(int val) {
            this.val = val;
        }
    }
}
