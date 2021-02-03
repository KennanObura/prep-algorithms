package kennan.co.ke.linkedlist;

public class MergeSortLinkedList {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(22);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(7);

        Node sorted = mergeSortList(head);

        while (sorted != null) {
            System.out.println(sorted.val);
            sorted = sorted.next;
        }

    }

    private static Node mergeSortList(Node current) {
        if (current == null || current.next == null) return current;

        Node midNode = getMidNode(current);

        Node temp = midNode.next;
        midNode.next = null;

        Node left = mergeSortList(current);
        Node right = mergeSortList(temp);

        return sortedList(left, right);
    }

    private static Node sortedList(Node left, Node right) {
        Node temp = new Node(-1);

        Node tail = temp;

        while (true) {
            if (left == null) {
                tail.next = right;
                break;
            }

            if (right == null) {
                tail.next = left;
                break;
            }

            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        return temp.next;
    }

    private static Node getMidNode(Node current) {
        if (current == null) return null;
        Node fast = current;
        Node slow = current;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static class Node {
        Node next;
        final int val;

        Node(int val) {
            this.val = val;
        }
    }
}
