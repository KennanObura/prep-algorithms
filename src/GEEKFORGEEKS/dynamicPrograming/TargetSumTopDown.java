package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class TargetSumTopDown {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int T = 3;

        System.out.println(targetSum(nums, T));
    }

    private static int targetSum(int[] nums, int T) {

        Map<String, Integer> map = new HashMap<>();
        int res =  targetSum(nums, T, nums.length - 1, 0, map);
        System.out.println(map);
        return res;
    }

    private static int targetSum(int[] nums, int T, int index, int sum, Map<String, Integer> map) {
        if (index < 0) {
            return (T == sum) ? 1 : 0;
        }

        String key = index + "|" + sum;

        if (!map.containsKey(key)) {
            int addValue = targetSum(nums, T, index - 1, sum + nums[index], map);
            int subValue = targetSum(nums, T, index - 1, sum - nums[index], map);

            map.put(key, addValue + subValue);

        }
        return map.get(key);
    }
}
