package TECHIEDELIGHT.linkedlist;

/**
 *
 */
public class RemoveRedundantNodes {
    private static class Node {
        int x, y;
        Node next;

        Node(int x, int y, Node next) {
            this.x = x;
            this.y = y;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static void print(Node current) {
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        int[][] keys = {{0, 1}, {0, 5}, {0, 8}, {2, 8},
                {5, 8}, {7, 8}, {7, 10}, {7, 12}};

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i][0], keys[i][1], head);
        }

        print(head);
        System.out.println("==================");
        Node current = removeRedundantNodes(head);
        print(current);

    }

    private static Node removeRedundantNodes(Node head) {
       /*
       Consider three consecutive nodes at a time
       say, current, next, next.next
       skip of they have same values, of x or y
        */

        Node current = head;
        Node temp = null;
        Node next = null;
        while (current.next != null && current.next.next != null) {
            next = current.next;
            temp = current.next.next;

            if(current.x == next.x && current.x == temp.x)
                current.next = temp;

            else if(current.y == next.y && current.y == temp.y)
                current.next = temp;
            else
                current = next;

        }
        return head;
    }
}
