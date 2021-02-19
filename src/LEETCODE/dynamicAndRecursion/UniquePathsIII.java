package LEETCODE.dynamicAndRecursion;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * <p>
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        int[][] grid2 = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int[][] grid3 = {{0, 1}, {2, 0}};

        System.out.println(uniquePathsIII(grid));
        System.out.println(uniquePathsIII(grid2));
        System.out.println(uniquePathsIII(grid3));

    }

    public static int uniquePathsIII(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++)
                if (grid[row][col] == 1) {
                    uniquePaths(grid, visited, row, col);
                    break;
                }
        }
        return COUNT;

    }

    static int COUNT = 0;

    private static boolean uniquePaths(int[][] grid, boolean[][] visited, int row, int col) {
        int N = grid.length;
        int M = grid[0].length;

        if (row < 0 || row >= N || col < 0 || col >= M || visited[row][col] || grid[row][col] == -1)
            return false;

        if (grid[row][col] == 2) {
            COUNT++;
            return true;
        }

        visited[row][col] = true;

        boolean right = uniquePaths(grid, visited, row, col + 1);
        boolean left = uniquePaths(grid, visited, row, col - 1);
        boolean up = uniquePaths(grid, visited, row - 1, col);
        boolean down = uniquePaths(grid, visited, row + 1, col);

        if (right && left && up && down) {
            visited[row][col] = false;
            return true;
        }

        return false;
    }
}
