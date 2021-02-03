package HACKERRANK;

public class DeleteNodeWithoutHeadPointer {
    public static void main(String[] args) {

        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        Node current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("");
        deleteNode(node2);

        Node newCurrent = head;
        while (newCurrent != null) {
            System.out.print(newCurrent.data + "->");
            newCurrent = newCurrent.next;
        }

    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private static void deleteNode(Node node) {
        // Your code here

        node.data = node.next.data;

        if (node.next.next != null)
            node.next = node.next.next;
        else node.next = null;
    }
}
