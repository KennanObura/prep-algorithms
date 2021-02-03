package BYTEBYBYTE.dynamicprograming;

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
 * <p>
 * NAIVE SOLUTION
 * Recursively
 * - Start at index 0 , move to end
 * either add or subtract an ith item
 * <p>
 * at the end, if @sum ==  T , include
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int T = 3;
        System.out.println(findNumWays(nums, T));
    }

    private static int findNumWays(int[] nums, int T) {
        return findNumWays(nums, T, 0, 0);
    }

    private static int findNumWays(int[] nums, int T, int index, int sum) {
        if (index == nums.length-1) {
            if (sum == T) return 1;
            else return 0;
        }

        return findNumWays(nums, T, index+1, sum + nums[index]) +
                findNumWays(nums, T, index+1, sum);

    }
}

