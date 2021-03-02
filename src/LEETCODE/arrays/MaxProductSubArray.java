package LEETCODE.arrays;

/**
 * 152. Maximum Product Subarray
 * Medium
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
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
public class MaxProductSubArray {
    public static void main(String[] args) {

        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));

        System.out.println(maxProduct(new int[]{2, 3}));

        System.out.println(maxProduct(new int[]{-2, 4}));

        System.out.println(maxProduct(new int[]{-2, 0, 0, 1}));
        System.out.println(maxProduct(new int[]{-2}));

    }

    public static int maxProduct(int[] nums) {
        /*
        let curr_max = the max of products seen till ith index
            cur_min = the min of products seen till ith index
            max_product = max_products so far

        loop from 0 ....N
               x = elem at i
            cur_max = max(x, max(x*cur_min, x*cur_max))
            cur_min = min(x, min(x*cur_min, x*cur_max))

            max_product = max(cur_max, max_product)

         */

        //  2, 3, -2, 4
        /*
        ind max min res
        0   2   2   2
        1   6   3   6
        2   -2  -12 -2
        3   4   -24 4

         */

        int N = nums.length;
        if(N == 1) return nums[0];

        int cur_max = 0, cur_min = 0, max_product = 0;

        for (int item : nums) {
            int temp = cur_max;
            cur_max = Math.max(item, Math.max(item * cur_max, item * cur_min));
            cur_min = Math.min(item, Math.max(item * temp, item * cur_min));
            max_product = Math.max(max_product, cur_max);
        }
        return max_product;

    }
}
