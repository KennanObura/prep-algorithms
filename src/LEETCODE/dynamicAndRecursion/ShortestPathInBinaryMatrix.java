package LEETCODE.dynamicAndRecursion;

/**
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * <p>
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * <p>
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        };

        System.out.println(shortestPathBinaryMatrix(grid));

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        return shortestPathBinaryMatrix(grid, 0, 0, 1);

    }

    private static int shortestPathBinaryMatrix(int[][] grid, int row, int col, int count) {
        if (row >= grid.length || col >= grid.length || grid[row][col] == 1) return 0;

        if(row == grid.length-1 && col == grid.length-1) {
            System.out.println(count);
            return count;
        }

        int moveRight = shortestPathBinaryMatrix(grid, row, col + 1, count+1);
        int moveDown = shortestPathBinaryMatrix(grid, row + 1, col, count+1);
        int moveDiagonal = shortestPathBinaryMatrix(grid, row + 1, col + 1, count+1);

        return Math.min(moveDiagonal, Math.min(moveDown, moveRight));
    }


}
