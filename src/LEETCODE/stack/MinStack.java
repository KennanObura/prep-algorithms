package LEETCODE.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * Easy
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */
public class MinStack {
    int min;
    Stack<Integer> stack;
    Stack<Integer> temp;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        temp = new Stack<>();
        min = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (min == Integer.MIN_VALUE)
            min = x;
        else {
            if (x < min) {
                stack.push(min);
                min = x;
            } else {
                stack.push(x);


                while (!stack.isEmpty() && stack.peek() < x)
                    temp.push(stack.pop());

                stack.push(x);
                while (!temp.isEmpty())
                    stack.push(temp.pop());
            }
        }
    }

    public void pop() {
        if (min > Integer.MIN_VALUE)
            min = stack.pop();
        else
            System.out.println("No elems");

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);


        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
