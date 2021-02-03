package TUTORIALHORIZON.ARRAYS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Objective: Given a two-dimensional array or matrix, Do the breadth-First Search (BFS)
 * to print the elements of the given matrix. Implement a Breadth-first traversal in an iterative manner.
 * <p>
 * Example:
 * <p>
 * int [][] grid = new int[][] {
 * {1, 2, 3, 4},
 * {5, 6, 7, 8},
 * {9, 10, 11, 12},
 * {13, 14, 15, 16}}
 * Output:
 * Breadth-First Traversal:
 * 1 2 5 3 6 9 4 7 10 13 8 11 14 12 15 16
 */

/* APPROACH
 *
 * Use Queue in BFS
 *
 * Given 2d matrix
 *
 * 1. Maintain Queue
 * 2. Maintain 2d boolean matrix, visited, of same size as given matrix
 * 3. put the first Position(0,0) to queue
 * 4. while queue not empty
 *      - poll from queue
 *      - check if ranges are valid and not visited
 *      - set visited
 *      - put to queue points
 *              going up
 *              going down
 *              going left
 *              going right
 *
 *
 */
public class FirstBreathSearchIn2DMatrix {


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        traverseInBFS(grid);
    }

    private static void traverseInBFS(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(0, 0));

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            int row = position.row;
            int col = position.col;

            if (isValidPositions(row, col, grid.length, grid[0].length) && !visited[row][col]) {

                visited[row][col] = true;
                System.out.print(grid[row][col] + " ,");

                queue.add(new Position(row, col - 1)); //move left
                queue.add(new Position(row, col + 1)); //move right
                queue.add(new Position(row - 1, col)); //move up
                queue.add(new Position(row + 1, col)); //move down
            }
        }
    }

    private static boolean isValidPositions(int row, int col, int rowLength, int colLength) {
        return row >= 0 && row < rowLength && col >= 0 && col < colLength;
    }


    private static class Position {
        final int col;
        final int row;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
