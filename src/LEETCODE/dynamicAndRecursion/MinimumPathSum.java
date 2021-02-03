package LEETCODE.dynamicAndRecursion;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] cache = new int[N][M];
        cache[0][0] = grid[0][0];

        for (int i = 1; i < N; i++)
            cache[i][0] = grid[i][0] + cache[i - 1][0];

        for (int i = 1; i < M; i++)
            cache[0][i] = grid[0][i] + cache[0][i - 1];

        for (int row = 1; row < N; row++)
            for (int col = 1; col < M; col++)
                cache[row][col] = Math.min(cache[row - 1][col], cache[row][col - 1]) + grid[row][col];

        return cache[N - 1][M - 1];
    }
}
