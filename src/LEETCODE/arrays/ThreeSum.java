package LEETCODE.arrays;

import java.util.*;

/**
 * 15. 3Sum
 * Medium
 * <p>
 * 9435
 * <p>
 * 967
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] list = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(list));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> listSet = new HashSet<>();
        List<Integer> internal;

        int N = nums.length;
        for (int i = 0; i < N - 2; i++) {
            int start = i + 1;
            int end = N - 1;


            while (start < end) {
                internal = new ArrayList<>();
                int temp = (nums[start] + nums[end]) + nums[i];
                if (temp < 0) start++;
                else if (temp > 0) end--;
                else {
                    internal.add(nums[i]);
                    internal.add(nums[start]);
                    internal.add(nums[end]);
                    listSet.add(internal);
                    start++;
                    end--;
                }

            }

        }

        return new ArrayList<>(listSet);
    }
}
