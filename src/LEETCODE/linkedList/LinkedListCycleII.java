package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 142. Linked List Cycle II
 * Medium
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Notice that you should not modify the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next;

        System.out.println(detectCycle(head));
    }

    private static int detectCycle(ListNode head) {
        if (head == null) return -1;

        ListNode slow = head, fast = head;
        boolean loopFound = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                loopFound = true;
                break;
            }
        }



        if (loopFound) {
            slow = head;
            int count = 0;
            while (slow != null) {
                if (slow == fast.next)
                    break;
                slow = slow.next;
                count++;
            }

            return count;
        }
        return -1;
    }
}
