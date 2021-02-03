package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;

/**
 * Objective: Given an array of integers (in particular order or permutation of a set of numbers), write an algorithm to find the lexicographically previous permutation of the given permutation with only one swap.
 * <p>
 * This problem can also be asked as “Given a permutation of numbers you need to find the next smaller premutation OR largest permutation which is smaller than the given permutation”
 * <p>
 * Note: In the case given permutation is smallest, return the given permutation.
 * <p>
 * Example:
 * <p>
 * Given Array: [1, 7, 3, 4, 5]
 * Largest permutation smaller than a given array: [1, 5, 3, 4, 7]
 * <p>
 * Given Array: [1, 2, 3, 4, 5]
 * Original Array is already the smallest permutation: [1, 2, 3, 4, 5]
 * <p>
 * Given Array: [4, 2, 5, 6]
 * Largest permutation smaller than a given array: [2, 4, 5, 6]
 */


/*
 *APPROACH
 * Given an array
 * def first_index, second_index
 *      1. Traverse from right to left
 *          first_index = i :: A[i] > A[i+1]
 *          if no such number, return the current
 *      2. Traverse from j=i ..N
 *          second_index = j :: A[i] > A[j] && A[j] < A[second_index]
 *      3. swap(first_index, second_index)
 *
 *
 */
public class LexicographicallyPreviousPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 4, 5};
        System.out.println(Arrays.toString(nextLargerPermutation(nums)));
    }

    private static int[] nextLargerPermutation(int[] nums) {

        int size = nums.length - 1;
        int start = -1;

        for (int i = size - 1; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == -1) return nums;

        int j = start;
        int second_num = Integer.MIN_VALUE;
        int second = -1;

        while (j <= size) {
            if (nums[start] > nums[j] && second_num < nums[j]) {
                second_num = nums[j];
                second = j;
            }
            j++;
        }

        nums[start] = swap(nums[second], nums[second] = nums[start]);


        return nums;
    }

    private static int swap(int i, int j) {
        return i;
    }
}
