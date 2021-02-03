package TUTORIALHORIZON.ARRAYS;

import java.util.Stack;

public class MatrixDFSIterative {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        doDepthFirstSearch(grid);
    }

    private static class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void doDepthFirstSearch(int[][] grid) {

        Stack<Position> stack = new Stack<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        stack.add(new Position(0, 0));

        while (!stack.isEmpty()) {
            Position current = stack.pop();

            if (isWithinRange(current, grid) && !visited[current.row][current.col]) {
                visited[current.row][current.col] = true;
                System.out.print(grid[current.row][current.col] + ", ");
                stack.add(new Position(current.row + 1, current.col));
                stack.add(new Position(current.row - 1, current.col));
                stack.add(new Position(current.row, current.col + 1));
                stack.add(new Position(current.row, current.col - 1));
            }
        }

    }

    private static boolean isWithinRange(Position current, int[][] grid) {
        return (current.row > -1 && current.col > -1 && current.row < grid.length && current.col < grid[0].length);
    }
}
