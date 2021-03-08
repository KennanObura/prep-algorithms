package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;

/**
 * Duplicate zero’s without expanding the array.
 * Given an array of numbers, you need to duplicate the zero’s in the array. Do not extend the size of array, just discard the remaining elements (had array gets extended, those elements) after the array size.
 * <p>
 * Example:
 * <p>
 * Input: [1, 0, 2, 3, 0, 4, 5, 0]
 * Output: [1, 0, 0, 2, 3, 0, 0, 4]
 * <p>
 * Input: [1, 0, 0, 0, 3, 4, 5]
 * Output: [1, 0, 0, 0, 0, 0, 0]
 * <p>
 * Input: [1, 2, 3]
 * Output: [1, 2, 3]
 * <p>
 * Input: [0, 0, 0]
 * Output: [0, 0, 0]
 */

public class DuplicateZeroWithoutExpandingArray {
    public static void main(String[] args) {

        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        System.out.print(Arrays.toString(duplicate(nums)));

        System.out.print(Arrays.toString(duplicate(new int[] {1, 0, 0, 0, 3, 4, 5})));
    }

    private static int[] duplicate(int[] nums) {
        int N = nums.length;

        int[] res = new int[N];
        int k = 0;

        for (int i = 0; i < N && k < N; i++) {
            int item = nums[i];
            if (k < N - 1 && item == 0) {
                res[k++] = item;
            }
            res[k++] = item;
        }


        return res;
    }
}
