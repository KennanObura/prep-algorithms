package TECHIEDELIGHT.linkedlist;

import LEETCODE.linkedList.Node.ListNode;

import java.util.Stack;

/**
 * https://www.techiedelight.com/add-single-digit-number-linked-list-representing-number/
 * <p>
 * Example 9->9->9->3    and 7
 * <p>
 * Output
 * 1->0->0->0->0
 */

/*
IDEA 1
Put list into stack
empty stack,
while popping off from stack, add and  create another list


IDEA 2
reverse whole list
Traverse list while adding
finally reverse the list again to its origin
 */
public class AddSingleDigitNumberUsingStack {
    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        A.next = new ListNode(2);
        A.next.next = new ListNode(9);
//        A.next.next.next = new ListNode(9);
//        A.next.next.next.next = new ListNode(9);
//        A.next.next.next.next.next = new ListNode(9);

        ListNode result = addUsingStack(A, 2);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }



    private static ListNode addUsingStack(ListNode current, int num) {
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.add(current.val);
            current = current.next;
        }

        int curry = num;
        ListNode resultNode = null;

        while (!stack.isEmpty()) {
            int val = stack.pop() + curry;
            curry = val / 10;

            ListNode newNode = new ListNode(val % 10);
            if(resultNode == null)
                resultNode = newNode;
            else{
                newNode.next = resultNode;
                resultNode = newNode;
            }
        }

        if(curry > 0){
            ListNode newNode = new ListNode(curry);
            newNode.next = resultNode;
            resultNode = newNode;
        }
      return resultNode;
    }


}
