package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 289. Game of Life
 * Medium
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {
    public static void main(String[] args) {

        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        gameOfLife(board);

        for (int[] row : board)
            System.out.println(Arrays.toString(row));

    }

    public static void gameOfLife(int[][] board) {

        int N = board.length;
        int M = board[0].length;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                int totalNeighbourLives = getNeighbourLives(board, row, col);
//                System.out.println(totalNeighbourLives);
                if (board[row][col] != 0) {
                    if (totalNeighbourLives < 2 || totalNeighbourLives > 3)
                        board[row][col] = 0;
                } else {
                    if (totalNeighbourLives == 3)
                        board[row][col] = 1;
                }

            }
        }

    }

    private static int getNeighbourLives(int[][] board, int row, int col) {
        int N = board.length;
        int M = board[0].length;
        int sum = 0;
        if (row - 1 >= 0) //check up
            sum += board[row - 1][col];

        if (col - 1 >= 0) // check left
            sum += board[row][col - 1];

        if (row + 1 < N) //check down
            sum += board[row + 1][col];

        if (col + 1 < M) // check right
            sum += board[row][col + 1];


        if (row - 1 >= 0 && col - 1 >= 0) //check top left
            sum += board[row - 1][col - 1];


        if (row - 1 >= 0 && col + 1 < M) //check top right
            sum += board[row - 1][col + 1];

        if (row + 1 < N && col + 1 < M) // check bottom right
            sum += board[row + 1][col + 1];

        if (row + 1 < N && col - 1 >= 0) // check bottom left
            sum += board[row + 1][col - 1];


        return sum;

    }
}
