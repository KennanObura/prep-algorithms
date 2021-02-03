package kennan.co.ke.DSImplementations.doublyLinkedList;

public class DoublyLinkedList<T> {
    DoublyLinkedListNode<T> head;
    DoublyLinkedListNode<T> tail;
    int size = 0;


    void addFirst(T value) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(value);
        if (head == null) {
            head = node;
            tail = head;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;

        head = node;
        size++;
    }

    void addAfter(T position, T value) {
        if (head == null) return;

        DoublyLinkedListNode<T> crawler = head;
        while (crawler != null) {
            if (crawler.value == position) {

                //if the item to be added after the last
                if (tail.value == position) {
                    addLast(value);
                    return;
                }

//                break the list from position

                DoublyLinkedListNode<T> temp = crawler.next;
                crawler.next = null;
                temp.prev = null;

                DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(value);
                newNode.next = temp;
                temp.prev = newNode;

                crawler.next = newNode;
                newNode.prev = crawler;
                return;

            }
            crawler = crawler.next;
        }
    }

    void addLast(T value) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(value);
        if (head == null && tail == null) {
            head = node;
            tail = head;
            size++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }


    void removeFirst() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    void removeLast() {
        if (tail == null) return;
        if (tail == head)
            removeFirst();

        else {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
                size--;
            }
        }
    }

    void print() {
        DoublyLinkedListNode<T> crawler = head;

        while (crawler != null) {
            System.out.print("{" + crawler.value + "}->");
//            if (crawler.prev != null)
//                System.out.print("{" + crawler.prev.value + "}");

            crawler = crawler.next;
        }
        System.out.println();
        if (tail != null)
            System.out.println(tail.value + " ==As tail==");
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addFirst("Mara");
        list.addFirst("froy");
        list.addFirst("port");
        list.addLast("end");
        list.addAfter("froy", "FFF");
        list.addAfter("end", "Not yet");
        list.print();
        list.removeFirst();

        list.print();

        list.removeLast();
        list.print();
    }
}
