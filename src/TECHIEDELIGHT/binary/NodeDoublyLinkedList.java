package TECHIEDELIGHT.binary;

public class NodeDoublyLinkedList<T> {
    public NodeDoublyLinkedList<T> prev;
    public NodeDoublyLinkedList<T> next;
    public T val;

    public NodeDoublyLinkedList(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "prev=" + prev +
                ", next=" + next +
                ", val=" + val +
                '}';
    }
}
