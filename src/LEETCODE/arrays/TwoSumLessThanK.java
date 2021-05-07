package LEETCODE.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K
 * Easy
 * <p>
 * Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [34,23,1,24,75,33,54,8], k = 60
 * Output: 58
 * Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [10,20,30], k = 15
 * Output: -1
 * Explanation: In this case it is not possible to get a pair sum less that 15.
 */
public class TwoSumLessThanK {
    public static void main(String[] args) {
        System.out.println(twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));

        System.out.println(twoSumLessThanK(new int[]{310, 20, 30}, 15));
    }

    public static int twoSumLessThanK(int[] nums, int k) {

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, maxSum = Integer.MIN_VALUE;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum >= k) j--;
            else {
                maxSum = Math.max(maxSum, sum);
                i++;
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}
