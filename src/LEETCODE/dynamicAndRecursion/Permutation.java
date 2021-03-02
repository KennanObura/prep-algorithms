package LEETCODE.dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Medium
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 */
public class Permutation {
    public static void main(String[] args) {

        System.out.println(permute(new int[]{1,2,3}));
        System.out.println(permute(new int[]{1,2}));
        System.out.println(permute(new int[]{}));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0,  result);
        return result;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> result) {
        int N = nums.length;
        if (index == N - 1) {
            ArrayList<Integer> internal = new ArrayList<>();
            for (int item : nums)
                internal.add(item);
            result.add(new ArrayList<>(internal));
            return;
        }
        if (index >= N) return;

        permute(nums, index + 1, result);
        for (int i = index + 1; i < N; i++) {
            nums[i] = swap(nums[index], nums[index] = nums[i]);
            permute(nums, index + 1, result);
            nums[i] = swap(nums[index], nums[index] = nums[i]);
        }
    }

    private static int swap(int num, int i) {
        return num;
    }
}
