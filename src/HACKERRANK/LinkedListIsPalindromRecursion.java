package HACKERRANK;

public class LinkedListIsPalindromRecursion {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(1);

        System.out.println(isPalindrome(root));

    }
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static boolean isPalindrome(Node root){
        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();

        isPalindrome(root, st1, st2);

        System.out.println(st1);
        System.out.println(st2);

        return st1.toString().equals(st2.toString());
    }

    static void isPalindrome(Node root, StringBuilder st1, StringBuilder st2){
        if(root == null) return;
        int item = root.data;
        st1.append(item);
        isPalindrome(root.next, st1, st2);
        st2.append(item);
    }
}
