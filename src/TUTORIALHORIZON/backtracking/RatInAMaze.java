package TUTORIALHORIZON.backtracking;

import kennan.co.ke.core.Pair;

import java.util.Arrays;

/**
 * Given a maze, NxN matrix. A rat has to find a path from source to destination.
 * maze[0][0] (left top corner)is the source and maze[N-1][N-1](right bottom corner) is destination.
 * There are few cells which are blocked, means rat cannot enter into those cells.
 * Rat can move in any direction ( left, right, up and down).
 * <p>
 * Input: A 2D-matrix with 0’s and 1’s fill in it. 0 means that cell is blocked and 1 means rat can move to that
 * cell.
 */
public class RatInAMaze {
    public static void main(String[] args) {
        int N = 5;
        int[][] maze = {{1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0}, {0, 0, 0, 1, 1}};
        RatPath r = new RatPath(N);
        r.findPathInMaze(maze);
    }
}

class RatPath {
    private final int N;
    private int PATH = 0;
    private final int[][] result;

    RatPath(int N) {
        this.N = N;
        result = new int[N][N];
    }

    public void findPathInMaze(int[][] maze) {
        boolean isPath = findPathInMaze(maze, 0, 0);
        if(isPath)
            printPath();
    }

    private void printPath() {
        for (int[] row : result)
            System.out.println(Arrays.toString(row));
    }

    private boolean findPathInMaze(int[][] maze, int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N || result[row][col] != 0 || maze[row][col] == 0)
            return false;

        result[row][col] = ++PATH;

        if (row == N - 1 && col == N - 1) return true;

        if (findPathInMaze(maze, row + 1, col)) return true;
        if (findPathInMaze(maze, row - 1, col)) return true;
        if (findPathInMaze(maze, row, col + 1)) return true;
        if (findPathInMaze(maze, row, col - 1)) return true;

        PATH--;
        result[row][col] = 0;
        return false;
    }
}
