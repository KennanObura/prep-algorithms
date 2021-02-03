package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;

/**
 * Objective: Given an array of integers write an algorithm to find all the subsets for which sum is equal to zero. The array contains both positive and negative integers.
 * <p>
 * Example:
 * <p>
 * Given Array: [8, 3, 5, 1, -4, -8], required sum: 0
 * Output:
 * [-8, -4, 1, 3, 8]
 * [-8, 3, 5]
 * [-8, 8]
 * [-4, 1, 3]
 * <p>
 * <p>
 * Given Array: [3, 1, -4, 2, 0], required sum: 0
 * Output:
 * [-4, 0, 1, 3]
 * [-4, 1, 3]
 * [0]
 */

public class SubsetsWithSumEqualsZero {
    public static void main(String[] args) {

        int[] nums = {8, 3, 5, 1, -4, -8};
        subsetOfSumZero(nums);
    }

    private static void subsetOfSumZero(int[] nums) {
        subsetOfSumZero(nums, nums.length - 1, 0, new ArrayList<>());
    }

    private static void subsetOfSumZero(int[] nums, int index, int sum, ArrayList<Integer> list) {
        if (sum == 0 && !list.isEmpty()) {
            System.out.println(list);
            return;
        }

        if (index < 0) return;

        /*
         * For every element , we consider it/ ignore it
         *  -    include into sum zero subset
         *  -    Dont include into sum zero subset
         *
         */

        list.add(nums[index]);
        subsetOfSumZero(nums, index - 1, sum + nums[index], list);
        list.remove(list.size() - 1);

        subsetOfSumZero(nums, index - 1, sum, list);
    }
}
