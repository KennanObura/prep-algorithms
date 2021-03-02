package LEETCODE.linkedList;

import LEETCODE.linkedList.Node.ListNode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 23. Merge k Sorted Lists
 * Hard
 * <p>
 * 6608
 * <p>
 * 344
 * <p>
 * Add to List
 * <p>
 * Share
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 */

public class MargeKSortedList {
    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode A = new ListNode(1);
        A.next = new ListNode(4);
        A.next.next = new ListNode(5);


        ListNode B = new ListNode(1);
        B.next = new ListNode(3);
        B.next.next = new ListNode(4);


        ListNode C = new ListNode(2);
        C.next = new ListNode(6);

        ListNode[] lists = {A, B, C};

        ListNode result = mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }


    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int K = lists.length;
        if (K == 1) return lists[0];

        TreeMap<Integer, ArrayList<ListNode>> map = new TreeMap<>(); // (k*r) -> P  = O(logP)

        for (ListNode head : lists) { //k*r
            while (head != null) {
                map.putIfAbsent(head.val, new ArrayList<>());
                map.get(head.val).add(head);
                head = head.next;
            }
        }

        ListNode resultHead = new ListNode(-1);
        ListNode tail = resultHead;
        for (Map.Entry<Integer, ArrayList<ListNode>> entry : map.entrySet()) {
            ArrayList<ListNode> nodes = entry.getValue();
            for (ListNode node : nodes) {
                tail.next = node;
                tail = node;
            }
        }

        return resultHead.next;
    }
}
