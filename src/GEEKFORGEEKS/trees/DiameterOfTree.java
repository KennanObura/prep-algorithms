package GEEKFORGEEKS.trees;


public class DiameterOfTree {
    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOfTree(root));

    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /**
     * Calculate left height,
     * Calculate right height,
     * Calculate left diameter
     * Calculate right diameter,
     * Take maximum between Max(leftDiameter, rightDiameter, leftHeight+rightHeight+1)
     *
     * @param root
     * @return
     */
    private static int diameterOfTree(Node root) {
        if (root == null) return 0;


        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);

        return Math.max(leftDiameter, Math.max(rightDiameter, leftHeight + rightHeight + 1));
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
