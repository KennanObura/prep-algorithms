package kennan.co.ke.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 */
public class SlidingWindowMaximumNumberUsingDequeue {
    public static void main(String[] args) {

        int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;

        printMaxItems(arr, k);

    }

    /*
     * Def a deque, (easy to remove and add at both ends)
     * Loop array
     *  for i < k
     *      pop while item to be added is more than items in queue
     *      add to deque
     *
     *  for i > k < N
     *      print peek;
     *      pop off items which are out of window
     *
     *      pop while item to be added is more than items in queue
     *      add to deque
     *
     *  print the last max item
     */

    static void printMaxItems(int[] nums, int winSize) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= winSize) {
                System.out.println(nums[deque.peek()]);

                while (!deque.isEmpty() && deque.peek() <= i - winSize)
                    deque.removeFirst();

            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }

        System.out.println(nums[deque.peek()]);
    }


}
