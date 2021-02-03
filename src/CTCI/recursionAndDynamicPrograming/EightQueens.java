package CTCI.recursionAndDynamicPrograming;

import java.util.Arrays;

public class EightQueens {
    public static void main(String[] args) {
        int N = 4;
        placed(N);
    }

    private static void placed(int N) {
        int[][] board = new int[N][N];

        if (placed(board, 0, N))
            System.out.println("Placed");
        else System.out.println("Impossible");

        for(int [] row: board)
            System.out.println(Arrays.toString(row));
    }

    private static boolean placed(int[][] board, int row, int N) {
        if (row == N) return true;

        for (int col = 0; col < N; col++) {
            if (isSafeToPlace(board, row, col)) {
                board[row][col] = 1;
                if (placed(board, row + 1, N)) return true;
            }
            board[row][col] = 0;
        }
        return false;
    }

    private static boolean isSafeToPlace(int[][] board, int row, int col) {
        int i = row;
        int j = col;

        while (j >= 0)
            if (board[row][j--] == 1) return false;

        while (i >= 0)
            if (board[i--][col] == 1) return false;

        i = row;
        j = col;

        while (i >= 0 && j >= 0)
            if (board[i--][j--] == 1) return false;

        j = col;
        i = row;
        while (i >= 0 && j < board.length)
            if (board[i--][j++] == 1) return false;

        return true;
    }
}
