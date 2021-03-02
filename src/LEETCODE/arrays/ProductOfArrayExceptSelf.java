package LEETCODE.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * Medium
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2})));
    }

    public static int[] productExceptSelf(int[] nums) {
        /*
        - Create Left[] and Right[] product arrays

        - for i ...N-1;
            result[i] = Left[i-1] * Right[i+1]
         */

        int N = nums.length;

        int[] leftProd = new int[N];
        int[] rightProd = new int[N];
        int[] result = new int[N];
        leftProd[0] = nums[0];
        int j = N - 1;
        rightProd[j] = nums[j];
        j--;

        for (int i = 1; i < N && j >= 0; i++, j--) {
            leftProd[i] = nums[i] * leftProd[i - 1];
            rightProd[j] = nums[j] * rightProd[j + 1];
        }


        result[N - 1] = leftProd[N - 2];
        result[0] = rightProd[1];

        for (int i = 1; i < N - 1; i++) {

            result[i] = leftProd[i - 1] * rightProd[i + 1];
        }

        return result;

    }
}
