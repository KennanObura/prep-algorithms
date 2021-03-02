package LEETCODE.dynamicAndRecursion;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));

        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        System.out.println(robRecur(new int[]{2, 7, 9, 3, 1}, 0));

    }

    public static int rob(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        if (N == 1) return nums[0];
        if (N == 2) return Math.max(nums[0], nums[1]);
        return rob(nums, 0, N - 1);
    }

    public static int rob(int[] nums, int start, int end) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);


        for (int i = start + 2; i <= end; i++)
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        return dp[end];
    }


    public static int robRecur(int[] nums, int index) {
        if (index >= nums.length) return 0;

        int rob = robRecur(nums, index + 2) + nums[index];
        int skip = robRecur(nums, index + 1);

        return Math.max(rob, skip);
    }


}
