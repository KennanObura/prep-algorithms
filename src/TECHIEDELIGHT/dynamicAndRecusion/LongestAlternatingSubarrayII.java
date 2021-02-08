package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

/**
 * Given an array of N including positive and negative numbers only.
 * The task is to find the length of the longest alternating (means negative-positive-negative or
 * positive-negative-positive) subarray present in the array.
 * <p>
 * Examples:
 * <p>
 * Input: a[] = {-5, -1, -1, 2, -2, -3}
 * Output: 3
 * The subarray {-1, 2, -2}
 * <p>
 * Input: a[] = {1, -5, 1, -5}
 * Output: 4
 */
public class LongestAlternatingSubarrayII {
    public static void main(String[] args) {
        int[] num = {-5, -1, -1, 2, -2, 3};
        int[] num2 = {1, -5, 1, -5};

        System.out.println(longestAlternatingSubarrayDP(num));
        System.out.println(longestAlternatingSubarrayDP(num2));
    }

    private static int longestAlternatingSubarrayDP(int[] array) {
        int[] cache = new int[array.length + 1];
        Arrays.fill(cache, 1);

        int maxLength = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] * array[i - 1] < 0)
                cache[i] += cache[i - 1];
            maxLength = Math.max(maxLength, cache[i]);
        }

        return maxLength;
    }

}
