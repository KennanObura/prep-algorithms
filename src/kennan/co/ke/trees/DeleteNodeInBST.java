package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

public class DeleteNodeInBST {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree(40);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(50);
        tree.insert(70);
        tree.insert(5);
        tree.insert(13);
        tree.insert(55);

        BinaryTreeNode<Integer> root = tree.getRoot();
        tree.printInorder(root);

        System.out.println();
        BinaryTreeNode<Integer> delete40 = deleteNode(root, 40);
        tree.printInorder(delete40);

    }

    private static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int value) {
        if (root == null) return null;

        if (root.value > value)
            root.left = deleteNode(root.left, value);
        else if (root.value < value)
            root.right = deleteNode(root.right, value);
            //CASE both not null
        else {
            if (root.right != null && root.left != null) {
                BinaryTreeNode<Integer> miniOfRight = getNextMinimum(root.right);
                root.value = miniOfRight.value;
                root.right = deleteNode(root.right, miniOfRight.value);
            }
            //case either is null
            else if (root.right != null)
                root = root.right;
            else if (root.left != null)
                root = root.left;
            else
//                case both are null
                root = null;

        }
        return root;
    }

    private static BinaryTreeNode<Integer> getNextMinimum(BinaryTreeNode<Integer> node) {
        if (node.left != null) return getNextMinimum(node.left);
        return node;
    }
}

class BinarySearchTree {
    BinaryTreeNode<Integer> root;

    BinarySearchTree(int value) {
        root = new BinaryTreeNode<>(value);
    }

    void insert(int value) {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(value);
        insert(root, node);
    }

    private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
        if (root == null) {
            root = node;
            return root;
        }

        if (root.value > node.value) {
            if (root.left == null)
                root.left = node;
            else
                root.left = insert(root.left, node);
        } else if (root.value < node.value) {
            if (root.right == null)
                root.right = node;
            else
                root.right = insert(root.right, node);
        }
        return root;
    }

    public BinaryTreeNode<Integer> getRoot() {
        return this.root;
    }


    public void printInorder(BinaryTreeNode<Integer> current) {
        if (current == null) return;
        printInorder(current.left);
        System.out.print(current.value + " , ");
        printInorder(current.right);
    }
}
