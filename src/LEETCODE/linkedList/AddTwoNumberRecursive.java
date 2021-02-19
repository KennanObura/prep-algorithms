package LEETCODE.linkedList;


import LEETCODE.linkedList.Node.ListNode;

public class AddTwoNumberRecursive {
    public static void main(String[] args) {

        ListNode A = new ListNode(2);
        A.next = new ListNode(4);
        A.next.next = new ListNode(3);


        ListNode B = new ListNode(5);
        B.next = new ListNode(6);
        B.next.next = new ListNode(4);


        ListNode result = addTwoNumbers(A, B);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }


    }
    /*

    1. Calculate sizes of Nodes A and B
        Case:
            Same size
                Add them recursively

            Not same
                Advance the longest node to Longest-Shortest Node
                Add them recursively
     */

    private static ListNode addTwoNumbers(ListNode A, ListNode B) {
        int lengthA = getSize(A);
        int lengthB = getSize(B);

        if (lengthA == lengthB)
            addTwoNumbersUtil(A, B);
        else {
            ListNode longest = lengthA > lengthB ? A : B;
            ListNode shortest = lengthA > lengthB ? B : A;

            int diff = Math.abs(lengthA - lengthB);
            ListNode current = longest;
            while (diff >= 0 && current != null) {
                diff--;
                current = current.next;
            }
            addTwoNumbersUtil(current, shortest);

        }

        return resultHead;

    }

    private static int getSize(ListNode node) {
        ListNode current = node;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    static int carry = 0;
    static ListNode resultHead = null;

    private static void addTwoNumbersUtil(ListNode A, ListNode B) {
        if (A == null) return;

        addTwoNumbers(A.next, B.next);

        int sum = A.val + B.val + carry;
        carry = sum / 10;

        int dig = sum % 10;

        attachToHead(dig);

    }

    private static void attachToHead(int dig) {
        ListNode node = new ListNode(dig);

        if (resultHead == null)
            resultHead = node;
        else {
            ListNode current = resultHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

    }
}
