package TUTORIALHORIZON.stack;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(6);
        stack.push(1);

System.out.println(sortStack(stack));
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int item = stack.pop();
            sortStack(stack);
            sortStackUtil(stack, item);
        }
        return stack;
    }

    private static void sortStackUtil(Stack<Integer> stack, int item) {
        if (stack.isEmpty() || stack.peek() < item)
            stack.push(item);
        else {
            //Pop till condition is met and insert back in recursion tail
            int popped = stack.pop();
            sortStackUtil(stack, item);

            stack.push(popped);
        }
    }
}
