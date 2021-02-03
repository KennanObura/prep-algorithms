package GEEKFORGEEKS.arrays;

import java.util.Arrays;

/**
 * Given a permutation of first n natural numbers as array and an integer k.
 * Print the lexicographically largest permutation after at most k swaps
 * Examples:
 * <p>
 * Input: arr[] = {4, 5, 2, 1, 3}
 * k = 3
 * Output: 5 4 3 2 1
 * Swap 1st and 2nd elements: 5 4 2 1 3
 * Swap 3rd and 5th elements: 5 4 3 1 2
 * Swap 4th and 5th elements: 5 4 3 2 1
 * <p>
 * Input: arr[] = {2, 1, 3}
 * k = 1
 * Output: 3 1 2
 * Swap 1st and 3re elements: 3 1 2
 *
 *
 * SOLUTION
 *
 * Define a pointer @CurrentIndex = 0 ;
 *
 * Cases
 *      index == length
 *      K == 0
 *          stop
 *
 *  Keep track of index where max is found @foundAtIndex
 *  scan from right till currentIndex
 *  if your i position == 0 , Means perm is in its largest possible number, break;
 *
 *  if foundAtIndex == currentIndex
 *      increment position and recur
 *  else swap elems at foundAtIndex & currentIndex
 *
 *  Increment currentIndex,
 *  decrement K
 *
 *  and recur
 *
 */
public class LargestPermutationAfterMostKSwaps {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1, 3};
        nextLargestAfterKSwaps(arr, 3, 0);
    }

    private static void nextLargestAfterKSwaps(int[] nums, int K, int currentIndex) {

        if (currentIndex >= nums.length || K <= 0) return;

        int foundMax = Integer.MIN_VALUE;
        int foundAtIndex = -1;
        int i = nums.length - 1;


        while (i >= currentIndex) {
            if (foundMax <= nums[i]) {
                foundAtIndex = i;
                foundMax = nums[i];
            }
            i--;
        }

        System.out.println(Arrays.toString(nums));

        if (foundAtIndex == 0) return; //Perm is in its largest form

        if (foundAtIndex == currentIndex)
            nextLargestAfterKSwaps(nums, K, currentIndex + 1);

        else {
            nums[currentIndex] = swap(nums[foundAtIndex], nums[foundAtIndex] = nums[currentIndex]);

            nextLargestAfterKSwaps(nums, K - 1, currentIndex + 1);
        }

    }

    private static int swap(int j, int i) {
        return j;
    }
}
