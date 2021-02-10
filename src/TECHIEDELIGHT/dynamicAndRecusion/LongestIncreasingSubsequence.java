package TECHIEDELIGHT.dynamicAndRecusion;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[] nums = {10, 1, 4, 2, 3, 11, 5};
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println(longestIncreasingSubsequence(nums));
        System.out.println(longestIncreasingSubsequence(A));

    }



    private static int longestIncreasingSubsequence(int[] array) {
        return longestIncreasingSubsequence(array, 0, -1);
    }

    private static int longestIncreasingSubsequence(int[] array, int i, int prev) {
        if (i >= array.length) return 0;

        if (array[i] <= prev)
            return longestIncreasingSubsequence(array, i + 1, prev);

        int include = longestIncreasingSubsequence(array, i + 1, array[i]) + 1;
        int notIncluded = longestIncreasingSubsequence(array, i + 1, prev);

        return Math.max(include, notIncluded);
    }
}
