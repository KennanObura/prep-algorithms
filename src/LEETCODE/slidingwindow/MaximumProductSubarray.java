package LEETCODE.slidingwindow;

/**
 * 152. Maximum Product Subarray
 * Medium
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {
    public static void main(String[] args) {

    }


    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int maxProd = nums[0];

        for (int item : nums) {
            int temp = max;
            max = Math.max(max, Math.max(max * item, min * item));
            min = Math.min(min, Math.min(temp * item, min * item));
            maxProd = Math.max(maxProd, max);

        }
        return maxProd;
    }
}
