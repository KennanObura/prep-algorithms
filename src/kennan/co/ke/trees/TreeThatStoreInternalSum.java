package kennan.co.ke.trees;

/**
 * Return a tree such that each internal node stores sum of all its child nodes. Each leaf node stores zero.
 */
public class TreeThatStoreInternalSum {
    public static void main(String[] args) {
        BNode root = new BNode(6);
        root.left = new BNode(4);
        root.left.left = new BNode(3);
        root.left.right = new BNode(2);

        root.right = new BNode(7);
        root.right.left = new BNode(11);

        SumTree sumTree = new SumTree(root);

        SumNode sumRoot = sumTree.build();
        print(sumRoot);
    }

    private static void print(SumNode node){
        if(node == null) return;
        print(node.left);
        System.out.println(node.val + " sum :" + node.sum);
        print(node.right);
    }

}

class SumTree {
    private final BNode root;

    SumTree(BNode root) {
        this.root = root;
    }

    SumNode build() {
        return build(root);
    }

    private SumNode build(BNode root) {
        if (root == null) return null;

        SumNode node = new SumNode(root.val);

        SumNode leftNode = null;
        SumNode rightNode = null;

        if (root.left != null) {
            leftNode = build(root.left);
            node.left = leftNode;
        }

        if (root.right != null) {
            rightNode = build(root.right);
            node.right = rightNode;
        }

        node.sum += (leftNode == null ? 0 : leftNode.val)
                + (rightNode == null ? 0 : rightNode.val);

        return node;
    }
}

class SumNode {
    SumNode left;
    SumNode right;
    int sum = 0;
    final int val;

    SumNode(int val) {
        this.val = val;
    }
}
