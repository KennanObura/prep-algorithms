package kennan.co.ke.stackandqueues;

import java.util.NoSuchElementException;


/**
 * Some modification made to this implementation to accommodate threshold @CAPACITY feature
 *
 * @param <T>
 */
public class StackImpl<T> {
    private static class Node<T> {
        final T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size = 0;

    StackImpl() {
        this.head = null;
    }

    public boolean push(T item) {
        if (isCapacityReached()) return false;
        if (add(item)) {
            size++;
            return true;
        }
        return false;
    }

    public boolean isCapacityReached() {
        int CAPACITY = 5;
        return (head != null && size == CAPACITY);
    }

    public boolean isEmpty() {
        return (size == 0 || head == null);
    }

    public T pop() {
        if (!isEmpty()) {
            return remove();
        }
        return null;
    }

    private T remove() {
        T value = head.value;
        head = head.next;
        System.gc();
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return head.value;
    }

    public int getSize() {
        return size;
    }

    private boolean add(T item) {
        Node<T> temp = new Node<>(item);
        if (isEmpty()) {
            head = temp;
            return true;
        }
        temp.next = head;
        head = temp;
        return true;
    }

    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackImpl<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        stack.push(4);


        System.out.println(stack.getSize() + " size");

        System.out.println(stack.peek() + " peek");


        while (!stack.isEmpty()){
            System.out.println(stack.pop());
//            stack.head = stack.head.next;
        }
    }
}
