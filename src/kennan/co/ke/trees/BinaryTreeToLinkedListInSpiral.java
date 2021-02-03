package kennan.co.ke.trees;


import java.util.Stack;

public class BinaryTreeToLinkedListInSpiral {
    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(10);
        root.left = new BinaryNode(8);
        root.left.left = new BinaryNode(5);
        root.left.left.left = new BinaryNode(2);
        root.left.left.right = new BinaryNode(1);
        root.left.right = new BinaryNode(6);

        root.right = new BinaryNode(9);
        root.right.left = new BinaryNode(4);
        root.right.right = new BinaryNode(12);
        root.right.left.right = new BinaryNode(3);

        Tree tree = new Tree(root);
        tree.spiralTraversal();
        tree.printList();
    }

    private static class Tree {
        final BinaryNode root;
        ListNode listHead;
        ListNode listTail;

        Tree(BinaryNode root) {
            this.root = root;
            this.listHead = null;
            this.listTail = null;
        }

        void printInOrder() {
            printInOrder(root);
            System.out.println();
        }

        void spiralTraversal() {
            BinaryNode current = root;

            Stack<BinaryNode> stack = new Stack<>();

            stack.add(current);

            boolean flag = false;

            while (!stack.isEmpty()) {
                Stack<BinaryNode> tempStack = new Stack<>();

                while (!stack.isEmpty()) {
                    BinaryNode node = stack.pop();
                    ListNode listNode = new ListNode(node.value);
                    if (listHead == null) {
                        listHead = listNode;
                        listTail = listNode;
                    } else {
                        listTail.next = listNode;
                        listTail = listTail.next;
                    }
                    if (flag) {
                        if (node.left != null) tempStack.push(node.left);
                        if (node.right != null) tempStack.push(node.right);
                    } else {
                        if (node.right != null) tempStack.push(node.right);
                        if (node.left != null) tempStack.push(node.left);
                    }

                }
                flag = !flag;
                stack = tempStack;
                System.out.println();
            }
        }

        private void printInOrder(BinaryNode node) {
            if (node == null) return;

            System.out.print(node.value);
            printInOrder(node.left);
            printInOrder(node.right);
        }


        public void printList() {
            ListNode current = listHead;
            while (current != null){
                System.out.print(current.value + ",");
                current = current.next;
            }

        }
    }

    private static class ListNode {
        ListNode next;
        final int value;

        ListNode(int value) {
            this.value = value;
        }
    }

    private static class BinaryNode {
        BinaryNode left;
        BinaryNode right;
        final int value;

        BinaryNode(int value) {
            this.value = value;
        }
    }


}
