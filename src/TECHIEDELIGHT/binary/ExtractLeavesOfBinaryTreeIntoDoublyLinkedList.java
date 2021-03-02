package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

/*
https://www.techiedelight.com/extract-leaves-of-binary-tree-into-doubly-linked-list/
 */

public class ExtractLeavesOfBinaryTreeIntoDoublyLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);




        preOrder(root, null, false);

        NodeDoublyLinkedList<Integer> res = head;

        preOrder(root, null, false);

        NodeDoublyLinkedList<Integer> aft = head;

        while (res != null) {

            if(res.prev != null)
                System.out.print(res.prev.val + "p ");
            res = res.next;
        }

//        System.out.println("=====================");
//        while (aft != null) {
//            System.out.print(aft + " ");
//            aft = aft.next;
//        }

    }


    private static void preOrder(TreeNode node, TreeNode parent, boolean isLeft) {
        if (node == null) return;

        //if is leaf
        if (isLeaf(node)) {
            linkToList(node.val);
            if (isLeft) parent.left = null;
            else parent.right = null;
            return;
        }
        preOrder(node.left, node, true);
        preOrder(node.right, node, false);
    }

    private static NodeDoublyLinkedList<Integer> head;

    private static void linkToList(int val) {
        NodeDoublyLinkedList<Integer> node = new NodeDoublyLinkedList<>(val);
        if (head == null) {
            head = node;
            return;
        }


        NodeDoublyLinkedList<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        node.prev = curr;

    }

    private static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

}
