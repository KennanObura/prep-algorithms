package LEETCODE.linkedList.Node;

public class ListNodePrinter {

    public static void print(ListNode current) {

        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }

    }

}
