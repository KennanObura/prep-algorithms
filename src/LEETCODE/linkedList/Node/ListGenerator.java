package LEETCODE.linkedList.Node;

public class ListGenerator {
    ListNode head;
    int[] elements;

    public ListGenerator(int[] elements) {
        this.elements = elements;
    }

    public ListNode get() {
        if (elements.length == 0) return null;

        head = new ListNode(-1);
        ListNode tail = head;
        for (int item : elements) {
            tail.next = new ListNode(item);
            tail = tail.next;
        }

        return head.next;
    }
}
