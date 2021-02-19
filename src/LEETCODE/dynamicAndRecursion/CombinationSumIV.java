package LEETCODE.dynamicAndRecursion;

/**
 * 377. Combination Sum IV
 * Medium
 * <p>
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 */
public class CombinationSumIV {
    public static void main(String[] args) {

        System.out.println(combinationSum4(new int[]{1, 2, 3}, 3));
    }


    public static int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, 0,0);
    }


    public static int combinationSum4(int[] nums, int target, int sum, int index) {

        if (target == sum)
            return 1;

        if (sum > target) return 0;

        int ways = 0;

        for (int i = index; i < nums.length ; i++) {
            sum += nums[i];
            ways += combinationSum4(nums, target, sum, i);
            sum -= nums[i];
        }

        return ways;

    }
}
