package kennan.co.ke.DSImplementations.doublyLinkedList;

public class DoublyLinkedListNode<T> {
    T value;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "DoublyLinkedListNode{" +
                "value=" + value +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
