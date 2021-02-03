package LEETCODE.leetcode;

import java.util.Arrays;

public class TotalDistinctNQueens {
    public static void main(String[] args) {

        Board board = new Board(4);
        System.out.println(board.totalNQueens(4));
    }


    private static class Board {
        final private int[][] board;
        final private int N;

        Board(int N) {
            this.N = N;
            this.board = new int[N][N];
        }

        public int totalNQueens(int n) {

            int count = 0;


            for (int col = 0; col < N; col++)
                if (isCompletelyPlaced(board, 0)) {
                    printBoard();
                    count++;
                }
            return count;
        }


        private boolean isCompletelyPlaced(int[][] board, int col) {
            if (col == N ) return true;

            for (int row = 0; row < N; row++) {
                if (isSafeToPlace(board, row, col)) {
                    board[row][col] = 1;
                    if (isCompletelyPlaced(board, col + 1))
                        return true;
                }
                board[row][col] = 0;
            }
            return false;
        }

        private boolean isSafeToPlace(int[][] board, int row, int col) {
            return isRowSafe(board, row, col) && isColSafe(board, row, col) && isDiagonalSafe(board, row, col);
        }

        private boolean isRowSafe(int[][] board, int row, int col) {
            int j = col;
            while (j > -1)
                if (board[row][j--] != 0) return false;
            return true;
        }

        private boolean isColSafe(int[][] board, int row, int col) {
            int j = row;
            while (j > -1)
                if (board[j--][col] != 0) return false;
            return true;
        }

        private boolean isDiagonalSafe(int[][] board, int row, int col) {
            int i = row;
            int j = col;
            while (i > -1 && j > -1)
                if (board[i--][j--] != 0) return false;
            return true;
        }

        private void printBoard() {
            System.out.println("=============board===================");
            for (int[] col : board)
                System.out.println(Arrays.toString(col));

        }
    }
}
