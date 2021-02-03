package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

/**
 * Longest Alternating Subsequence is a problem of finding a subsequence of a given
 * sequence in which the elements are in alternating order, and in which the sequence is as long as possible
 * <p>
 * In order words, we need to find the length of longest subsequence with alternate low and high elements.
 * <p>
 * The problem differs from problem of finding longest alternating subarray.
 * Unlike subarrays, subsequences are not required to occupy consecutive positions within the original
 * sequences.
 * <p>
 * For example, consider array
 * A[] = [8, 9, 6, 4, 5, 7, 3, 2, 4]
 * <p>
 * The length of longest subsequence is 6 and the subsequence is [8, 9, 6, 7, 3, 4]
 * (8 < 9 > 6 < 7 > 3 < 4)
 * Note that the Longest Subsequence is not unique.
 * Below are few more subsequences of length 6
 * <p>
 * (8, 9, 6, 7, 2, 4)
 * (8, 9, 4, 7, 3, 4)
 * (8, 9, 4, 7, 2, 4)
 * and many more..
 */
public class LongestAlternatingSequence {
    public static void main(String[] args) {
        int[] nums = {8, 9, 6, 4, 5, 7, 3, 2, 4};
        int[] nums2 = {10, 22, 9, 33, 49, 50, 31, 60};
        int[] nums3 = {2, 3, 4, 8, 2, 6, 5, 4};
        int[] nums4 = {2, 3, 4, 8, 2, 5, 6, 8};
        int[] nums5 = {6, 5, 9, 2, 10, 77, 5};
        System.out.println(longestAlternatingSequence(nums));
        System.out.println(longestAlternatingSequence(nums2));

        System.out.println(longestAlternatingSequence(nums3));

        System.out.println(longestAlternatingSequence(nums4));
        System.out.println(longestAlternatingSequence(nums5));
    }

    private static int longestAlternatingSequence(int[] nums) {

        boolean[] flagCache = new boolean[nums.length];
        boolean[] flagCacheII = new boolean[nums.length];

        flagCache[0] = true;
        flagCacheII[0] = true;

        for (int i = 1; i < nums.length; i++) {
            flagCache[i] = nums[i] < nums[i - 1];
            flagCacheII[i] = nums[i] > nums[i - 1];
        }

        int count = 1;
        for (int i = 1; i < flagCache.length; i++)
            if (flagCache[i - 1] != flagCache[i]) count++;


        System.out.println(Arrays.toString(flagCache));
        System.out.println(Arrays.toString(flagCacheII));

        return count;
    }

    private static int longestAlternatingSequenceRecur(int[] nums) {

        int N = nums.length - 1;
//        return Math.max(longestAlternatingSequence(nums, N, true),
//                longestAlternatingSequence(nums, N, false));
        return 1 + Math.max(Util(nums, 1, N, true), Util(nums, 1, N, false));
    }


    private static int longestAlternatingSequence(int[] nums, int N, boolean flag) {
        if (N == 1) return 1;

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (flag && nums[i] > nums[i - 1]) {
                result = Math.max(result, longestAlternatingSequence(nums, N - 1, !flag) + 1);
            } else if (!flag && nums[N] < nums[N - 1]) {
                result = Math.max(result, longestAlternatingSequence(nums, N - 1, !flag) + 1);
            } else
                result = Math.max(result, longestAlternatingSequence(nums, N - 1, flag));
        }
        return result;
    }

    public static int Util(int[] A, int start, int end, boolean flag) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            // include A[i] as next high in subsequence and flip flag
            // for next subsequence
            if (flag && A[i - 1] < A[i]) {
                res = Integer.max(res, 1 + Util(A, i + 1, end, !flag));
            }
            // include A[i] as next low in subsequence and flip flag
            // for next subsequence
            else if (!flag && A[i - 1] > A[i]) {
                res = Integer.max(res, 1 + Util(A, i + 1, end, !flag));
            }
            // don't include A[i] in subsequence
            else {
                res = Integer.max(res, Util(A, i + 1, end, flag));
            }
        }

        return res;
    }
}
