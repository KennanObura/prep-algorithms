package kennan.co.ke.trees;

public class BinaryTreeFromInorderAndPostOrderLists {
    public static void main(String[] args) {
        int[] inorder = {2, 3, 4, 5, 6, 8, 10};
        int[] postOrder = {5, 3, 2, 4, 8, 6, 10};

        BTree tree = new BTree(inorder, postOrder);
        BNode root = tree.build();
        tree.print(root);
    }
}

class BTree {
    BNode root;
    int[] inorder;
    int[] preOrder;

    BTree(int[] inorder, int[] preOrder) {
        this.inorder = inorder;
        this.preOrder = preOrder;
    }

    public BNode build() {
        root = build(0, preOrder.length - 1);
        return root;
    }
    int preOrderIndex = 0;
    private BNode build(int start, int end ) {
        if (start > end) return null;

        BNode node = new BNode(preOrder[preOrderIndex]);
        preOrderIndex++;

        if (start == end) return node;

        int index = doBinarySearch(start, end, node.val);

        if(index == -1) return null;

        node.left = build(start, index - 1);
        node.right = build(index + 1, end);
        return node;
    }

    private int doBinarySearch(int start, int end, int val) {
        if (start > end) return -1;

        int mid = getMid(start, end);
        if (inorder[mid] == val) return mid;
        if (inorder[mid] > val)
            return doBinarySearch(start, mid - 1, val);
        else return doBinarySearch(mid + 1, end, val);
    }

    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    public void print(BNode root) {
        if (root == null) return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }
}

class BNode {
    BNode left;
    BNode right;
    final int val;

    BNode(int val) {
        this.val = val;
    }
}