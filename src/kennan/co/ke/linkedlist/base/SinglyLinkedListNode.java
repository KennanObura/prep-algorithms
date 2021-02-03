package kennan.co.ke.linkedlist.base;

public class SinglyLinkedListNode<T> {

    public SinglyLinkedListNode(T value) {
        this.value = value;
    }

    public T value;
    public SinglyLinkedListNode<T> next;

    @Override
    public String toString() {
        return "SinglyLinkedListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

