package kennan.co.ke.linkedlist;

public class ReverseInGroupsOfK {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);

        Node reversed = reverseInGroups(root, 2);

        while (reversed != null) {
            System.out.print(reversed.val + " ,");
            reversed = reversed.next;
        }
    }

    private static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    private static Node reverseInGroups(Node root, int k) {
        if (root == null) return null;

        Node current = root, prev = null, next = null;


        int j = 0;
        while (j++ < k && current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        if(next != null)
            root.next = reverseInGroups(next, k);

        return prev;
    }


}
