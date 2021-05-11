package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 1508. Range Sum of Sorted Subarray Sums
 * Medium
 * <p>
 * Given the array nums consisting of n positive integers. You computed the sum of all non-empty continous subarrays from the array and then sort them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
 * <p>
 * Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
 * Output: 13
 * Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
 * Output: 6
 * Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
 * Output: 50
 */
public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int[] result = new int[n * (n + 1) / 2];

        int k = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                result[k++] = sum;
            }
        }

        Arrays.sort(result);

        long sum = 0;
        for (int i = left - 1; i < right; i++)
            sum += result[i];

        if (sum > Integer.MAX_VALUE)
            sum = sum % 1000000007;
        return (int) sum;
    }
}
