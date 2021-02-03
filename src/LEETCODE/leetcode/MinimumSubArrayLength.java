package LEETCODE.leetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSubArrayLength {
    public static void main(String[] args) {
        int s = 7;

        int[] nums = {2, 3, 1, 2, 4, 3};

        int s2 = 15;
        int[] nums2 = {1,2,3,4,5};

        System.out.println(minSubArrayLen(s2, nums2));
    }

    public static int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) return 0;

        int MIN_LENGTH = Integer.MAX_VALUE;

        int start = 0, currentSum = 0;
        int end = 0;
        while (end < nums.length) {
            currentSum += nums[end++];

            while (currentSum >= s) {
                MIN_LENGTH = Math.min(MIN_LENGTH, end - start);
                currentSum -= nums[start++];
            }
        }


        return MIN_LENGTH == Integer.MAX_VALUE ? 0 : MIN_LENGTH;
    }
}
