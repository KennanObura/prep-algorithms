package kennan.co.ke.stackandqueues;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class SortingStack {

    private final Stack<Integer> stack;

    public SortingStack() {
        this.stack = new Stack<>();
    }

    public int pop() {
        return stack.pop();
    }

    public int push(int item) {
        if (isEmpty()) return stack.push(item);
        return sortAndPushNewElem(item);
    }

    private int sortAndPushNewElem(int item) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty() && item > stack.peek())
            temp.add(stack.pop());

        stack.add(item);

        while (!temp.isEmpty())
            stack.push(temp.pop());

        return item;
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortingStack stack = new SortingStack();
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.push(7);
        stack.push(2);

        System.out.println(stack.peek() + " as peek");

        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
