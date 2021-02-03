package kennan.co.ke.linkedlist.base;

public class PrintList {
    public static void print(SinglyLinkedListNode<Integer> current) {
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println();
    }
}
