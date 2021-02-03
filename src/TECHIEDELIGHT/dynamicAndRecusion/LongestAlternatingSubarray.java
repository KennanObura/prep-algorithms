package TECHIEDELIGHT.dynamicAndRecusion;

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
public class LongestAlternatingSubarray {
    public static void main(String[] args) {
        int[] num = {-5, -1, -1, 2, -2, -3};
        int[] num2 = {1, -5, 1, -5};

        System.out.println(longestAlternatingSubarrayDP(num));
        System.out.println(longestAlternatingSubarrayDP(num2));
        System.out.println("==============================");
        System.out.println(longestAlternatingSubarray(num));
        System.out.println(longestAlternatingSubarray(num2));
    }

    private static int longestAlternatingSubarrayDP(int[] array) {
        int[] cache = new int[array.length + 1];
        cache[0] = 1;

        int longest = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            cache[i]++;
            if (array[i - 1] * array[i] < 0)
                cache[i] += cache[i - 1];

            longest = Math.max(longest, cache[i]);
        }
        return longest;
    }


    private static int longestAlternatingSubarray(int[] array) {

        int longestSoFar = 1;
        int longest = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] * array[i] < 0) {
                longestSoFar++;
            }else
                longestSoFar = 1;

            longest = Math.max(longest, longestSoFar);
        }
        return longest;
    }
}
