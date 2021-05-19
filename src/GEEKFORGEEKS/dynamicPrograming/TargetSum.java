package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;

/**
 * Given an array of integers, nums and a target value T, find the
 * number of ways that you can add and subtract the values in
 * nums to add up to T.
 * eg.
 * nums = {1, 1, 1, 1, 1}
 * T = 3
 * 1 + 1 + 1 + 1 - 1
 * 1 + 1 + 1 - 1 + 1
 * 1 + 1 - 1 + 1 + 1
 * 1 - 1 + 1 + 1 + 1
 * -1 + 1 + 1 + 1 + 1
 * targetSum(nums, T) = 5
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int T = 3;

        System.out.println(targetSum(nums, T));
    }

    private static int targetSum(int[] nums, int T) {
        return targetSum(nums, T, nums.length - 1, 0);
    }

    private static int targetSum(int[] nums, int T, int index, int sum) {
        if (index < 0) {
            return (T == sum) ? 1 : 0;
        }


        int addValue = targetSum(nums, T, index - 1, sum + nums[index]);
        int subValue = targetSum(nums, T, index - 1, sum - nums[index]);

        return addValue + subValue;
    }
}
