package LEETCODE.dynamicAndRecursion;

/**
 * 300. Longest Increasing Subsequence
 * <p>
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
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

    public static int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, 0, -1);

    }

    private static int lengthOfLIS(int[] nums, int index, int prev) {
        if (index >= nums.length) return 0;

        if (nums[index] <= prev)
            return lengthOfLIS(nums, index + 1, prev);


        int include = lengthOfLIS(nums, index + 1, nums[index]) + 1;
        int exclude = lengthOfLIS(nums, index + 1, prev);

        return Math.max(include, exclude);
    }
}
