package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

public class LongestIncreasingSubsequenceBottomUp {
    public static void main(String[] args) {

        int[] nums = {10, 1, 4, 2, 3, 11, 5};
        int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] nums2 = {1,3,6,7,9,4,10,5,6};

        System.out.println(longestIncreasingSubsequence(nums));
        System.out.println(longestIncreasingSubsequence(A));
        System.out.println(longestIncreasingSubsequence(nums2));
        System.out.println(LIS(nums2));

    }

    public static int LIS(int[] A)
    {
        // array to store subproblem solution. `L[i]` stores the length
        // of the longest increasing subsequence that ends with `A[i]`
        int[] L = new int[A.length];

        // the longest increasing subsequence ending with `A[0]` has length 1
        L[0] = 1;

        // start from the second array element
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in subarray `A[0…i-1]`
            for (int j = 0; j < i; j++)
            {
                // find the longest increasing subsequence that ends with `A[j]`
                // where `A[j]` is less than the current element `A[i]`
                if (A[j] < A[i] && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }
            // include `A[i]` in LIS
            L[i]++;
        }

        // return longest increasing subsequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }

    private static int longestIncreasingSubsequence(int[] array) {
        int N = array.length;
        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j] && dp[j] > dp[i])
                    dp[i] = dp[j];
            }
            dp[i]++;
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

}
