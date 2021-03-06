package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListGenerator;
import LEETCODE.linkedList.Node.ListNode;
import LEETCODE.linkedList.Node.ListNodePrinter;

/**
 * 725. Split Linked List in Parts
 * <p>
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * <p>
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * <p>
 * Return a List of ListNode's representing the linked list parts that are formed.
 * <p>
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 */
public class SplitLinkedListIntoParts {
    public static void main(String[] args) {

        ListGenerator generator = new ListGenerator(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode head = generator.get();

//        ListNodePrinter.print(head);

        ListNode[] result = splitListToParts(head, 3);
        for (ListNode headList : result) {
            while (headList != null) {
                ListNode current = headList;
                ListNodePrinter.print(current);
                headList = headList.next;

            }
            System.out.println("");
        }

    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];

        ListNode current = root;
        int N = getListSize(current);
        int perSlot = N / k;
        int remaining = N % k;

        splitListToParts(root, k, perSlot, remaining, result, 0);
        return result;
    }

    private static void splitListToParts(ListNode root, int K, int N, int R, ListNode[] result, int index) {
        if (root.next == null || index >= K) return;

        ListNode current = root;
        for (int i = 0; i < N && current != null; i++)
            current = current.next;

        if (R > 0 && current != null) {
            current = current.next;
            R -= 1;
        }

        ListNode temp = current.next;
        current.next = null;
        result[index] = root;

        splitListToParts(temp, K, N, R, result, index + 1);

    }

    private static int getListSize(ListNode current) {

        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
