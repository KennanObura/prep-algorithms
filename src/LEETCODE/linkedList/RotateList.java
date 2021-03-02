package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

/**
 * 61. Rotate List
 * Medium
 * Given the head of a linked list, rotate the list to the right by k places.
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 */
public class RotateList {
    public static void main(String[] args) {

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
//        A.next.next.next = new ListNode(4);
//        A.next.next.next.next = new ListNode(5);
//        A.next.next.next.next.next = new ListNode(6);

        ListNode result = rotateRight(A, 4);

        print(result);

    }


    private static void print(ListNode node) {
        ListNode result = node;
        while (result != null) {
            System.out.print(result.val + "-");
            result = result.next;
        }
        System.out.println();
    }

    private static ListNode rotateRight(ListNode head, int k) {
        int size = getListSize(head);
        if (size == k) return head;
        int diff = Math.abs(size - k);

        int firstPart = (k > size) ? size - diff : diff;


        ListNode cur = head;
        ListNode prev = null, next;

        while (firstPart > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            firstPart--;
        }


        ListNode firstPartHead = (prev != null) ? prev : head; // 4->3->2->1


        ListNode firstPartCurr = firstPartHead; //pointer to move to tail
        while (firstPartCurr != null && firstPartCurr.next != null) {
            firstPartCurr = firstPartCurr.next;
        }


        prev = null;
        next = null;
        while (cur != null) { //reverse last part
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

//        print(firstPartHead); // 6->5

        firstPartCurr.next = prev;



        next = null;
        prev = null;
        cur = firstPartHead;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static int getListSize(ListNode head) {
        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
