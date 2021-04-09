package RANDOM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Objective: Given an array of integers A[] which is sorted in two parts (both parts are individually sorted), find no of reverse pairs means no of (i, j) pairs where i belongs to the part one and j belongs to part 2 and A[i]>A[j].
 * <p>
 * Example:
 * <p>
 * A[] = {4, 6, 8, 9, 1, 5, 10, 11}
 * <p>
 * Output:  7
 * Explanation:
 * Part one: {4, 6, 8, 9}
 * Part two: {1, 5, 10, 11}
 * Reversed pairs: (4, 1) (6, 1) (6, 5) (8, 1) (8, 5) (9, 1) (9, 5) = 7
 */
public class NumberOfReversePairs {
    public static void main(String[] args) {
        System.out.println(numberOfReversePairs(new int[]{4, 6, 8, 9, 0, 1, 2, 5, 10, 11}));
    }


    private static int numberOfReversePairs(int[] nums) {
        int N = nums.length;
        int i = 1;
        while (i < N - 1) {
            if (nums[i - 1] > nums[i])
                break;
            i++;
        }

        int k = i;
        int j = k;

        i = 0;

        int count = 0;

        while (i <= k && j < N) {
            if (nums[i] <= nums[j])
                i++;
            else if (nums[i] > nums[j]) {
                count += k - i + 1;
                j++;
            }
        }


        return count;
    }
}
