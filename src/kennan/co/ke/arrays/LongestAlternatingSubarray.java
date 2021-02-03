package kennan.co.ke.arrays;

/**
 * Given an array of N including positive and negative numbers only.
 * The task is to find the length of the longest alternating
 * (means negative-positive-negative or positive-negative-positive) subarray present in the array.
 * <p>
 * Approach: The following steps are followed to solve the problem:
 * <p>
 * Initially initialize @count as 1.
 * Iterate among the array elements, check if it has an alternate sign.
 * Increase the @count by 1 if it has a alternate sign.
 * If it does not has an alternate sign, then re-initialize count to 1.
 */


public class LongestAlternatingSubarray {
    public static void main(String[] args) {
        int[] array = {-5, -1, -1, 2, -2, -3};
        int[] array1 = {1, -5, 1, -5};
        System.out.println(solve(array) + " ");
        System.out.println(solve(array1) + " ");

        System.out.println(solveII(array) + " ");
        System.out.println(solveII(array1) + " ");
    }

    private static int solve(int[] array) {
        int count = 1;
        int longest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] * array[i + 1] < 0) {
                count++;
                longest = Math.max(count, longest);
            } else count = 1;
        }
        return longest;
    }


    private static int solveII(int[] array) {
        int count = 1;
        int longest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] < 0 && array[i + 1] > 0) || (array[i] > 0 && array[i + 1] < 0) ) {
                count++;
                longest = Math.max(count, longest);
            } else count = 1;
        }
        return longest;
    }
}
