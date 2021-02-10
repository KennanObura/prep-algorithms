package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

/**
 * https://www.techiedelight.com/find-ways-fill-n-x-4-matrix-with-1-x-4-tiles/
 * Given nx4 matrix where n is a positive number, find number of ways to fill matrix with 4x1 tiles
 */
public class WaysToFillMatrixWithTiles {
    public static void main(String[] args) {

        System.out.println(ways(15));
        System.out.println(waysBottomUp(15));
    }

    private static int ways(int N) {
        if (N < 0) return 0;

        if (N < 4) return 1;

        if (N == 4) return 2;

        return ways(N - 1) + ways(N - 4);
    }


    private static int waysBottomUp(int N) {
        int[] dp = new int[N + 1];

        Arrays.fill(dp, 1, 3, 1);
        dp[4] = 2;

        for (int i = 5; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 4];

        return dp[N];
    }
}
