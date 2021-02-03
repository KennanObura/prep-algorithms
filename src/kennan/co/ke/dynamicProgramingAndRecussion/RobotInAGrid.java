package kennan.co.ke.dynamicProgramingAndRecussion;

import java.util.Arrays;

public class RobotInAGrid {
    private static int PATH = 1;

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 1, 1}
        };

        findRobotPath(grid);
    }

    private static void findRobotPath(int[][] grid) {
        int[][] solution = new int[grid.length][grid[0].length];

        if (findRobotPath(grid, solution, 0, 0)) printPath(solution);
    }

    private static void printPath(int[][] solution) {
        for (int[] col : solution)
            System.out.println(Arrays.toString(col));
    }

    private static boolean findRobotPath(int[][] grid, int[][] solution, int row, int col) {
        if (!canMove(grid, solution, row, col)) return false;

        solution[row][col] = PATH++;

        if (row == grid.length - 1 && col == grid.length - 1) return true;

        if (findRobotPath(grid, solution, row + 1, col)) return true;
        if (findRobotPath(grid, solution, row, col + 1)) return true;

        solution[row][col] = 0;
        PATH--;

        return false;

    }

    private static boolean canMove(int[][] grid, int[][] solution, int row, int col) {
        return row > -1 && row < grid.length && col > -1 && col < grid[0].length
                && grid[row][col] != 0 && solution[row][col] == 0;
    }
}
