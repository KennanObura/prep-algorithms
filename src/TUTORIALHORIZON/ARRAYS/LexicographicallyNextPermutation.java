package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;

/**
 * Objective: Given an array of integers (in particular order or permutation of a set of numbers),
 * write an algorithm to find the lexicographically next permutation of the given permutation with only one swap.
 * <p>
 * This problem can also be asked as “Given a permutation of numbers you need to find the next larger permutation
 * OR smallest permutation which is greater than the given permutation“.
 * <p>
 * Note: In the case given permutation is largest, return the given permutation.
 * <p>
 * Example:
 * <p>
 * Given Array: [1, 7, 3, 4, 5]
 * smallest permutation greater than given array: [1, 7, 3, 5, 4]
 * <p>
 * Given Array: [5, 4, 3, 2, 1]
 * Original Array is already the largest possible permutation: [5, 4, 3, 2, 1]
 * <p>
 * Given Array: [4, 2, 5, 1, 0]
 * smallest permutation greater than given array: [4, 5, 0, 1, 2]
 */


/*
 *APPROACH
 * Given an array
 * def first_index, second_index
 *      1. Traverse from right to left
 *          first_index = i :: A[i-1] < A[i]
 *          if no such number, return the current
 *      2. Traverse from j=i ..N
 *          second_index = j :: A[j] > A[i] && A[j] > A[second_index]
 *      3. swap(first_index, second_index)
 *      4. sort from i..N
 *
 */
public class LexicographicallyNextPermutation {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(nextLargerPermutation(nums)));
    }

    private static int[] nextLargerPermutation(int[] nums) {

        int size = nums.length - 1;
        int start = -1;

        for (int i = size - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == -1) return nums;

        int j = start;
        int second = -1;
        int second_num = Integer.MAX_VALUE;
        while (j <= size) {
            if (nums[j] > nums[start] && second_num > nums[j]) {
                second_num = nums[j];
                second = j;
            }
            j++;
        }

        if (second == -1) return nums;

        nums[start] = swap(nums[second], nums[second] = nums[start]);

        Arrays.sort(nums, start+1, size+1);
        return nums;
    }

    private static int swap(int i, int j) {
        return i;
    }
}
