package JAVACORE.designpatterns.momento;

import java.util.Stack;

public class History {
    private final Stack<State> stack = new Stack<>();

    public void push(State state) {
        stack.push(state);
    }

    public State pop() {
        if (stack.isEmpty()) throw new RuntimeException("You can not undo further");
        return stack.pop();
    }

    public State peek() {
        if (stack.isEmpty()) return new State("");
        return stack.peek();
    }
}
