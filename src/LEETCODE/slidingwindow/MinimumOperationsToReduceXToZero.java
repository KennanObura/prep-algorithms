package LEETCODE.slidingwindow;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * Medium
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 * <p>
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));

    }

    private static int minOperations(int[] nums, int x) {
        int N = nums.length;
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (N == sum) return sum;
        int diffWin = sum - x;

        int start = 0, end = 0, currentSum = 0, minOps = Integer.MAX_VALUE;

        for (; end < N; end++) {
            currentSum += nums[end];

            while (currentSum > diffWin)
                currentSum -= nums[start++];

            if (currentSum == diffWin) {
                int currentOps = start + (N - 1 - end);
                minOps = Math.min(currentOps, minOps);
            }
        }
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}
