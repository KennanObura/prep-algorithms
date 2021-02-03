package TUTORIALHORIZON.stack;

import java.util.Stack;

public class ReverseStackInPlace {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(6);
        stack.push(1);

        System.out.println(reverse(stack));
    }

    /*
    Keep popping from stack while its not empty

    And on recursion tail, call reverseUtil
        - push if the stack is empty,
        - otherwise pop and recur
        - push back at the recursion tail
     */

    private static Stack<Integer> reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int item = stack.pop();
            reverse(stack);
            stackReverseUtil(stack, item);
        }
        return stack;
    }

    private static void stackReverseUtil(Stack<Integer> stack, int item) {
        if(stack.isEmpty()) {
            stack.push(item);
        }else {
            int popped = stack.pop();
            stackReverseUtil(stack, item);
            stack.push(popped);
        }
    }


}
