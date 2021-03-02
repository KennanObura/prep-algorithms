package LEETCODE.dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 18. 4Sum
 * Medium
 * <p>
 * 2923
 * <p>
 * 394
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Notice that the solution set must not contain duplicate quadruplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * <p>
 * Input: nums = [], target = 0
 * Output: []
 */
public class FourSum {
    public static void main(String[] args) {

        List<List<Integer>> result = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

//        for(List list : result)
        System.out.println(result);


    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        fourSum(nums, target, 0, new ArrayList<>(), 4, 0);
        return result;

    }

    private static void fourSum(int[] nums, int target, int index, List<Integer> internal, int count, int sum) {

        if (count == 0 && sum == target) {
            result.add(new ArrayList<>(internal));
            return;
        }

        if (index >= nums.length) return;


        internal.add(nums[index]);
        fourSum(nums, target, index + 1, internal, count - 1, sum + nums[index]);
        internal.remove(internal.size() - 1);
        fourSum(nums, target, index + 1, internal, count, sum);

    }
}
