package LEETCODE.dynamicAndRecursion;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsIIBottomUp {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 0},
                {1, 1},
                {0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] cache = new int[n][m];

//        if (obstacleGrid[0][0] == 1) return 0;


        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            cache[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            cache[0][i] = 1;
        }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (obstacleGrid[i][j] == 1) cache[i][j] = 0;
                else cache[i][j] = cache[i - 1][j] + cache[i][j - 1];

        return cache[n - 1][m - 1];
    }


}
