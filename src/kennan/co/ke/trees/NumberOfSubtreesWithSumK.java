package kennan.co.ke.trees;

/**
 * iven a Binary tree and an integer. You need to find the number of subtrees
 * having the sum of all of its nodes equal to given Integer, that is, Target sum.
 */
public class NumberOfSubtreesWithSumK {
    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.left.right.left = new Node(5);

        root.right = new Node(60);
        root.right.left = new Node(50);
        root.right.left.right = new Node(55);
        root.right.right = new Node(70);

        int target = 45;

        int max = countSubtree(root, 0, 0, target);

        System.out.print(max);

    }

    private static int countSubtree(Node root, int sum, int count, int target) {
        if(root == null) return 0;

        int left = countSubtree(root.left, sum+ root.val, count, target);
        int right = countSubtree(root.right, sum+ root.val, count, target);

        System.out.println(left);
        if(left+right == target){
            System.out.println(root.val);
            count++;
        }
        return count;
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
