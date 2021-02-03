package TUTORIALHORIZON.ARRAYS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Objective: Given an array and integer k, write an algorithm to find the maximum element in each subarray of size k.
 * <p>
 * Example:
 * <p>
 * int [] nums = { 1, 2, 3, 2, 4, 1, 5, 6,1};
 * Output: 3, 3, 4, 4, 5, 6, 6
 */

/*
 * APPROACH 1
 * for 0..n-k
 *      for i..i+k
 *          max
 *
 *
 * APPROACH II
 * Given array and int k
 *      Maintain a deque
 *
 *      for 0..k
 *      keep removing from q while peek elem is less than ith
 *      add ith
 *
 *      for i=k ..N
 *      keep removing items out of window
 *          remove while peek <= i-k
 *
 *      keep removing from q while peek elem is less than ith
 *      add ith
 */
public class MaxOfSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1, 5, 6, 1};
        int k = 3;

        //Naive
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            System.out.print(max + " ");
        }

        System.out.println();

        solve(nums, k);

    }

    private static void solve(int[] nums, int k) {
        if (nums.length < k)
            return;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                System.out.print(nums[deque.peek()]+ " ");
                while (!deque.isEmpty() && deque.peek() <= i - k)
                    deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();

            deque.add(i);
        }
        System.out.print(deque.peek());
    }
}
