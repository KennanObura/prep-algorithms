package LEETCODE.arrays;

/**
 * 665. Non-decreasing Array
 * Medium
 * <p>
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));

        System.out.println(checkPossibility(new int[]{4, 2, 1}));

        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));

        System.out.println(checkPossibility(new int[]{2, 2, 4, 2, 3}));

        System.out.println(checkPossibility(new int[]{1}));
    }

    public static boolean checkPossibility(int[] nums) {
        int N = nums.length;

        if (N <= 2) return true;

        boolean modified = false;

        for (int i = 1; i < N; i++) {
            if (nums[i - 1] > nums[i]) {

                if (modified) return false;

                modified = true;

                if (i < 2 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }

        }
        return true;
    }

}
