package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.List;


/**
 * 18. 4Sum
 * Medium
 * <p>
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

        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }


    private static List<List<Integer>> fourSum(int[] nums, int target) {

        /*
        Naive
        Using recursion
        let index = N-1
            K = 4
            list = resultList
            currentList to hold current items of size K



            every elem has a choice of being in result set
                Either add in set or dont add in set
                - Add -> do
                            target - A[index]
                            K -1
                            add item to currentList
                            index-1 to consider others

                - Do not add -> do
                            remove last elem of in currentList
                            index -1


           Base case
            K == 0  && target == 0
                add currentList to resultList
                return

            K < 0 || index < 0 || target < 0
                return

         */


        fourSum(nums, target, nums.length - 1, 4, new ArrayList<Integer>());
        return resultList;
    }

    static int count = 0;
    private static void fourSum(int[] nums, int target, int i, int K, ArrayList<Integer> internal) {
        if (target == 0 && K == 0) {
            resultList.add(new ArrayList<>(internal));
            return;
        }


        if (i < 0) return;

        System.out.println(count++);

        /*
        Consider this current item
         */
        internal.add(nums[i]);
        fourSum(nums, target - nums[i], i - 1, K - 1, internal);

        /*
        Backtrack to consider other item
         */
        internal.remove(internal.size() - 1);
        fourSum(nums, target, i - 1, K, internal);
    }

    private static final List<List<Integer>> resultList = new ArrayList<>();

}
