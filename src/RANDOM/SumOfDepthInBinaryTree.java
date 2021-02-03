package RANDOM;

public class SumOfDepthInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println(sumDepth(root, 0));

    }

    private static int sumDepth(Node root, int count) {
        if (root == null) return 0;

//        if (root.left == null && root.right == null) {
//            System.out.println(count);
//            return count+1;
//        }

        int sumOnLeft = sumDepth(root.left, count)+1;
        int sumOnRight = sumDepth(root.right, count)+1;

        return sumOnLeft + sumOnRight;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

}

