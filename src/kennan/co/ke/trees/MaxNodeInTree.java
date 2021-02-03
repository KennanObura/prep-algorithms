package kennan.co.ke.trees;

public class MaxNodeInTree {
    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(30);

        root.right = new Node(60);
        root.right.left = new Node(50);
        root.right.right = new Node(70);


        int max = getMaxNode(root, Integer.MIN_VALUE);

        System.out.print(max);

    }

    private static int getMaxNode(Node root, int max) {
        if (root == null) {
            max = Math.max(0, max);
            return max;
        }

        int leftMax = getMaxNode(root.left, Math.max(root.val, max));
        int rightMax = getMaxNode(root.right, Math.max(root.val, max));

        return Math.max(leftMax, rightMax);
    }

    private static class Node {
        Node left;
        Node right;
        final int val;

        Node(int val) {
            this.val = val;
        }
    }


}
