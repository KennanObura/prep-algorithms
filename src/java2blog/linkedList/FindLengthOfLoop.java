package java2blog.linkedList;

import LEETCODE.linkedList.Node.ListNode;

public class FindLengthOfLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next;

        System.out.println(lengthOfLoop(head));
    }

    private static int lengthOfLoop(ListNode node) {

        boolean loopPresent = false;

        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                loopPresent = true;
                break;
            }
        }


        if (loopPresent)
            return countLoop(fast);

        System.out.println(fast.val);
        return 0;

    }

    private static int countLoop(ListNode node) {
        ListNode temp = node;
        int count = 1;
        while (temp.next != node) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
