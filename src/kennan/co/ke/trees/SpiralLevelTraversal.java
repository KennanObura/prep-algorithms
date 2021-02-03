package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTreeNode;

import java.util.Stack;

/* ALGORITHM
 * 1 - create an empty stack
 * 2 - push root to it
 * while stack is not empty
 * 3 - create empty stack temp
 * 4 - pop from stack and push children to temp stack depending on direction flag
 *
 */
public class SpiralLevelTraversal {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(40);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(60);
        root.left.left = new BinaryTreeNode<>(10);
        root.left.right = new BinaryTreeNode<>(30);
        root.left.left.left = new BinaryTreeNode<>(5);

        root.right.left = new BinaryTreeNode<>(50);
        root.right.left.right = new BinaryTreeNode<>(55);
        root.right.right = new BinaryTreeNode<>(70);

        spiralLevel(root);
    }

    private static void spiralLevel(BinaryTreeNode<Integer> root) {

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

        stack.push(root);
        boolean goLeft = false;

        while (!stack.isEmpty()) {
            Stack<BinaryTreeNode<Integer>> temp = new Stack<>();

            while (!stack.isEmpty()) {
                BinaryTreeNode<Integer> node = stack.pop();
                System.out.println(node.value);
                if (goLeft) {
                    if (node.left != null) temp.push(node.left);
                    if (node.right != null) temp.push(node.right);
                } else {
                    if (node.right != null) temp.push(node.right);
                    if (node.left != null) temp.push(node.left);
                }
            }
            goLeft = !goLeft;
            stack = temp;
        }

    }


}
