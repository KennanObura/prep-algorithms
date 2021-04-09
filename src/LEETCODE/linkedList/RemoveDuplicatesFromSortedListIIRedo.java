package LEETCODE.linkedList;


import LEETCODE.linkedList.Node.ListNode;

import java.util.*;

public class RemoveDuplicatesFromSortedListIIRedo {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

        ListNode result = deleteDuplicates(head);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        Map<Integer, Integer> set = new LinkedHashMap<>();
        ListNode current = head;
        while (current != null) {
            set.put(current.val, set.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        ListNode result = new ListNode(-1);
        ListNode tail = result;


        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
            if (entry.getValue() > 1) continue;

            tail.next = new ListNode(entry.getKey());
            tail = tail.next;
        }

        return result.next;
    }
}
