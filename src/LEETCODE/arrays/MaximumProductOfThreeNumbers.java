package LEETCODE.arrays;

/**
 * 628. Maximum Product of Three Numbers
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 * <p>
 * Input: nums = [-1,-2,-3]
 * Output: -6
 */
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {

        System.out.println(maximumProduct(new int[]{3, 2, 1, 4}));

        System.out.println(maximumProduct(new int[]{3, 2, 1}));

        System.out.println(maximumProduct(new int[]{-1, -2, -3}));

        System.out.println(maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}));

    }


    private static int maximumProduct(int[] nums) {
        if (nums.length < 3) return -1;
        /*
        Solution 1:
        Assuming inputs are valid
            Sort items in ascending order
            return product of A[N-1] * A[N-2] * A[N-3] in O(nlogn)


        Solution 2
            let max be the max elem in array
                sec_max = second max elem in array
                third_max = 3rd max elem

             // Accommodate negative entries
            let min be the min elem in array
                sec_min be the second min elem

            do single pass and update values of max, sec_max, third_max

            return Max((max * sec_max * third_max), max * min * sec_min)  O(N)
         */


        int max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE, third_max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, sec_min = Integer.MAX_VALUE;

        for (int item : nums) {

            if (item < min) {
                sec_min = min;
                min = item;
            } else if (item < sec_min)
                sec_min = item;


            if (item > max) {
                third_max = sec_max;
                sec_max = max;
                max = item;
            } else if (item > sec_max) {
                third_max = sec_max;
                sec_max = item;
            } else if (item > third_max)
                third_max = item;

        }

        return Math.max((max * sec_max * third_max), (max * min * sec_min));
    }

}
