package LEETCODE.dynamicAndRecursion;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 */
public class UniquePathsBottomUp {
    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 4));

    }

    public static int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < cache.length; i++)
            cache[i][0] = 1;
        for (int i = 0; i < cache[0].length; i++)
            cache[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];

        return cache[m - 1][n - 1];
    }
}
