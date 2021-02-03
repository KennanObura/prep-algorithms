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
public class UniquePathsII {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return uniquePathsWithObstacles(obstacleGrid, 0, 0);

    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (row >= n || col >= m || obstacleGrid[row][col] == 1) return 0;

        if (row == n - 1 && col == m - 1) return 1;

        return uniquePathsWithObstacles(obstacleGrid, row, col + 1)
                + uniquePathsWithObstacles(obstacleGrid, row + 1, col);
    }
}
