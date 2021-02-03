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

        System.out.println(uniquePathsIII(grid));

    }

    public static int uniquePathsIII(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];

        int obstacles = 0;
        int holes = (M * N) - obstacles;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (grid[i][j] == -1) obstacles++;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1)
                    return uniquePaths(grid, visited, i, j, 1, holes);
            }

        }

        return 0;

    }

    private static int uniquePaths(int[][] grid, boolean[][] visited, int row, int col, int counts, int holes) {
        int N = grid.length;
        int M = grid[0].length;
        if (row < 0 || row >= N || col < 0 || col >= M || grid[row][col] == -1 || visited[row][col]) return 0;

        System.out.println(counts);
        if (grid[row][col] == 2 && counts == holes) {
            return 1;
        }

        visited[row][col] = true;
        counts++;



        return uniquePaths(grid, visited, row + 1, col, counts, holes)
                + uniquePaths(grid, visited, row - 1, col, counts, holes)
                + uniquePaths(grid, visited, row, col + 1, counts, holes)
                + uniquePaths(grid, visited, row, col - 1, counts, holes);
    }
}
