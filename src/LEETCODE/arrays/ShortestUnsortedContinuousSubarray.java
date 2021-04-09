package LEETCODE.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * Medium
 * <p>
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 * <p>
 * Return the shortest such subarray and output its length.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 0
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {

        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        /*
        - Copy array
        - Sort coppied array
        - keep keeys of the copied array and scan to find mountains

         */

        int[] copied = nums.clone();
        Arrays.sort(copied);

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (nums[i] != copied[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }

        return left == Integer.MAX_VALUE ? 0 : right - left + 1;

    }
}
