package LEETCODE.arrays;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 * Example 1:
 *
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 */
public class IslandParameter {
    public static void main(String[] args) {
        int [][] grid = {
                {1,0,0},
                {1,1,0}
        };

        int [][] grid2 = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        int [][] grid3 = {
                {0,1,0,0},
        };


        System.out.println(islandPerimeter(grid2));
        System.out.println(islandPerimeter(grid));
        System.out.println(islandPerimeter(grid3));

    }

    public static int islandPerimeter(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int parameter = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (grid[row][col] == 1)
                    parameter += islandPerimeter(grid, row, col, 4);
            }

        }


        return parameter;
    }

    private static int islandPerimeter(int[][] grid, int row, int col, int sum) {
        if (row - 1 >= 0 && grid[row - 1][col] == 1) --sum;
        if (row + 1 < grid.length && grid[row + 1][col] == 1) --sum;
        if (col - 1 >= 0 && grid[row][col - 1] == 1) --sum;
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) --sum;
        return sum;
    }
}
