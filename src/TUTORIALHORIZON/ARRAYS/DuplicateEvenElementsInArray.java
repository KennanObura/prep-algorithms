package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;

/**
 * Duplicate even elements in an array
 * January 1, 2021 by Sumit Jain
 * Given an array of numbers, write a program to duplicate the even numbers and return the new array.
 * <p>
 * Example:
 * <p>
 * Input: [2, 4, 1, 5, 2, 3, 8, 9, 10, 4]
 * Output: [2, 2, 4, 4, 1, 5, 2, 2, 3, 8, 8, 9, 10, 10, 4, 4]
 * <p>
 * Input: [2, 4, 6, 8]
 * Output: [2, 2, 4, 4, 6, 6, 8, 8]
 * <p>
 * Input: [1, 3, 5, 6]
 * Output: [1, 3, 5, 6, 6]
 */
public class DuplicateEvenElementsInArray {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(duplicateEvens(new int[]{1, 2, 3, 5})));
        System.out.println(Arrays.toString(duplicateEvens(new int[]{2, 4, 1, 5, 2, 3, 8, 9, 10, 4})));
        System.out.println(Arrays.toString(duplicateEvens(new int[]{1, 3, 5})));

    }

    private static int[] duplicateEvens(int[] nums) {
        /*
        let N be length of nums
        - count evens, count
        - create result array, result, of size N + count, M

        let k = pointer of result positions

        for i = 0 ... N & k < M
            let elem be ith elem in nums
            if elem is even
                place in result and advance k
             place elem in result and advance k

         */

        int N = nums.length;
        int count = 0;

        for (int item : nums)
            if ((item & 1) != 1)
                count++;

        int M = N + count;
        int[] result = new int[M];
        int k = 0;

        for (int i = 0; i < N && k < M; i++) {
            int element = nums[i];
            if ((element & 1) != 1)
                result[k++] = element;
            result[k++] = element;
        }
        return result;
    }
}
