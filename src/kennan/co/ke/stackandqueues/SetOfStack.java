package kennan.co.ke.stackandqueues;

import java.util.Stack;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 */
public class SetOfStack<T> {

    final StackImpl<StackImpl<T>> stack;

    SetOfStack() {
        this.stack = new StackImpl<>();
    }

    void push(T item) {
        if (isEmpty()) addNewItemSet(item);
        else pushToThePeekOfSet(item);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public T pop() {
        if (stack.peek().isEmpty()) {
            stack.pop();
            if (!stack.isEmpty())
                return stack.peek().pop();

        } else
            return stack.peek().pop();
        return null;
    }


    private void pushToThePeekOfSet(T item) {
        StackImpl<T> peek = stack.peek();
        if (!peek.push(item)) addNewItemSet(item);
    }

    private void addNewItemSet(T item) {
        StackImpl<T> st = new StackImpl<>();
        if (st.push(item))
            stack.push(st);
    }


    public static void main(String[] args) {
        SetOfStack<Integer> setOfStack = new SetOfStack<>();
        setOfStack.push(1);
        setOfStack.push(2);
        setOfStack.push(3);
        setOfStack.push(4);
        setOfStack.push(5);

        setOfStack.push(6);
        setOfStack.push(7);
        setOfStack.push(8);
        setOfStack.push(9);
        setOfStack.push(10);

        setOfStack.push(11);

        while (!setOfStack.isEmpty()) {
            Integer item = setOfStack.pop();
            System.out.println(item);
        }
    }
}
