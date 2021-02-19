package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 128. Longest Consecutive Sequence
 * Hard
 * <p>
 * 4649
 * <p>
 * 226
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

        System.out.println(longestConsecutive(new int[]{-4, -1, -2, -3, 0, 100, 4, 200, 1, 3, 2}));

    }

    public static int longestConsecutive(int[] nums) {
        int N = nums.length;
        if(N == 0) return 0;
        if(N == 1) return 1;

        Arrays.sort(nums);

        int[] dp = new int[N];
        dp[0] = 1;

        int prev = nums[0];
        int maxLength = 1;

        for (int i = 1; i < N; i++) {
            if (prev == nums[i])
                dp[i] = dp[i - 1];
            else if (prev + 1 == nums[i])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;

            prev = nums[i];
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;

    }
}
