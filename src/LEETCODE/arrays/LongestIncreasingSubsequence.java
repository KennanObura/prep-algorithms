package LEETCODE.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums1 = {0, 1, 0, 3, 2, 3};
        int[] nums2 = {7, 7, 7, 7, 7, 7, 7};
        int[] nums3 = {0, 0, 0, 0, 1, 1, 2, 3, 0, 0, 1, 1, 0, 3};
        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};

//        System.out.println(lengthOfLIS(nums));
//        System.out.println(lengthOfLIS(nums1));
//        System.out.println(lengthOfLIS(nums2));
//        System.out.println(lengthOfLIS(nums3));
        System.out.println(lengthOfLIS(nums4));
    }


    static private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }


        }

        System.out.println(Arrays.toString(dp));
        return len;
    }

    private static int lengthOfLISII(int[] nums) {
        int[] currentLengthDP = new int[nums.length];

        currentLengthDP[0] = 1;

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {

            int currentMaxLength = 0;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    currentMaxLength = Math.max(currentMaxLength, currentLengthDP[j]);

            currentLengthDP[i] = currentMaxLength + 1;
            result = Math.max(result, currentLengthDP[i]);

        }
        System.out.println(Arrays.toString(currentLengthDP));
        return result;
    }


}
