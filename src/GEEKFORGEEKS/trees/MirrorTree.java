package GEEKFORGEEKS.trees;

public class MirrorTree {
    public static void main(String[] args) {

    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }


    private static void mirror(Node node) {
        // Your code here

    }


    private static Node mirrorUtil(Node node) {
        if(node == null) return null;

        Node left = mirrorUtil(node.left);
        Node right = mirrorUtil(node.right);

        node.right = left;
        node.left =  right;
        return node;
    }
}
