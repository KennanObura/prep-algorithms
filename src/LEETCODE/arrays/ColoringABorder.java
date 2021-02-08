package LEETCODE.arrays;

import java.util.Arrays;

/**
 * Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.
 * <p>
 * Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.
 * <p>
 * The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 * <p>
 * Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * Output: [[3, 3], [3, 2]]
 * Example 2:
 * <p>
 * Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * Output: [[1, 3, 3], [2, 3, 3]]
 * Example 3:
 * <p>
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 */
public class ColoringABorder {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1},
                {1, 2}
        };
        int[][] grid2 = {
                {1, 2, 1},
                {1, 2, 2},
                {2, 2, 1}
        };
        int[][] grid3 = {
                {1, 1, 1, 1},
                {1, 2, 2, 2},
                {1, 2, 2, 2}
        };

        int[][] grid4 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int[][] result = colorBorder(grid4, 1, 1, 2);

        for (int[] row : result)
            System.out.println(Arrays.toString(row));
    }

    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int currentColor = grid[r0][c0];
        colorBorderUtil(grid, r0, c0, color, currentColor);
        if (r0 != 0 && c0 != 0)
            grid[r0][c0] = currentColor;
        return grid;
    }

    private static void colorBorderUtil(int[][] grid, int row, int col, int color, int currentColor) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != currentColor || grid[row][col] == color) return;

        grid[row][col] = color;

        colorBorderUtil(grid, row - 1, col, color, currentColor);
        colorBorderUtil(grid, row + 1, col, color, currentColor);
        colorBorderUtil(grid, row, col + 1, color, currentColor);
        colorBorderUtil(grid, row, col - 1, color, currentColor);

    }
}
