package kennan.co.ke.stackandqueues;


import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingTwoStacks<T> {
    Stack<T> stack;
    Stack<T> other;

    QueueUsingTwoStacks() {
        this.stack = new Stack<>();
        this.other = new Stack<>();
    }


    public void add(T item) {
        if (isEmpty())
            stack.add(item);
        else popAndSwapOther(item);
    }

    public T peek() {
        return stack.peek();
    }

    public T remove() {
        if (!isEmpty()) return stack.pop();
        else throw new EmptyStackException();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    private void popAndSwapOther(T item) {
        while (!stack.isEmpty())
            other.add(stack.pop());

        stack.add(item);

        while (!other.isEmpty())
            stack.add(other.pop());
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue.peek());

        while (!queue.isEmpty())
            System.out.println(queue.remove());


    }

}
