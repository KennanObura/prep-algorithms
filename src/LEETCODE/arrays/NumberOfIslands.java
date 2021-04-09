package LEETCODE.arrays;

/**
 * 200. Number of Islands
 * Medium
 * <p>
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid3 = {
                {'0', '1', '0'},
                {'1', '0', '1'},
                {'0', '1', '0'}
        };

        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {

        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for (int row = 0; row < N; row++)
            for (int col = 0; col < M; col++)
                if (grid[row][col] == '1' && !visited[row][col]) {
                    visitIsland(grid, visited, row, col);
                    count++;
                }
        return count;
    }

    private static void visitIsland(char[][] grid, boolean[][] visited, int row, int col) {
        int N = grid.length;
        int M = grid[0].length;
        if (row < 0 || row >= N || col < 0 || col >= M || grid[row][col] == '0' || visited[row][col])
            return;

        visited[row][col] = true;

        visitIsland(grid, visited, row - 1, col);
        visitIsland(grid, visited, row + 1, col);
        visitIsland(grid, visited, row, col + 1);
        visitIsland(grid, visited, row, col - 1);

    }
}


