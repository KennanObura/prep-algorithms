package kennan.co.ke.linkedlist.base;

public class SinglyLinkedList<T> {

    SinglyLinkedListNode<T> head;
    SinglyLinkedListNode<T> tail;
    private int size = 0;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(SinglyLinkedListNode<T> node) {
        head = add(head, node);
    }

    private SinglyLinkedListNode<T> add(SinglyLinkedListNode<T> head, SinglyLinkedListNode<T> node) {
        size++;
        if (head == null) {
            tail = node;
            return node;
        }

        tail.next = node;
        tail = tail.next;
        return head;
    }

    public SinglyLinkedListNode<T> getHead() {
        return this.head;
    }

    public SinglyLinkedListNode<T> getTail() {
        return this.tail;
    }

    int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
