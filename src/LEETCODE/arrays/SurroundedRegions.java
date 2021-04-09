package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 130. Surrounded Regions
 * Medium
 * <p>
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 * <p>
 * Input: board = [["X"]]
 * Output: [["X"]]
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}
        };

        solve(board);
    }

    public static void solve(char[][] board) {
        int N = board.length;
        int M = board[0].length;

        boolean[][] visited = new boolean[N][M];

        for (int row = 1; row < N - 2; row++) {
            for (int col = 1; col < M - 2; col++) {
                if (board[row][col] == 'O' && !visited[row][col])
                    capture(board, visited, row, col);

            }
        }


        for (char[] row : board)
            System.out.println(Arrays.toString(row));

    }

    private static boolean capture(char[][] board, boolean[][] visited, int row, int col) {
        int N = board.length;
        int M = board[0].length;

        if ((row == N - 2 && board[row + 1][col] == 'O') || (row == 1 && board[row - 1][col] == 'O')
                || (col == M - 2 && board[row][col + 1] == 'O') || (col == 1 && board[row][col - 1] == 'O'))
            return false;


        visited[row][col] = true;
        board[row][col] = 'X';

        if (isValidMove(board, visited, row + 1, col) && capture(board, visited, row + 1, col))
            return true;
        if (isValidMove(board, visited, row - 1, col) && capture(board, visited, row - 1, col))
            return true;
        if (isValidMove(board, visited, row, col + 1) && capture(board, visited, row, col + 1))
            return true;
        if (isValidMove(board, visited, row, col - 1) && capture(board, visited, row, col - 1))
            return true;

//        board[row][col] = 'O';
        return false;
    }

    private static boolean isValidMove(char[][] board, boolean[][] visited, int row, int col) {
        int N = board.length;
        int M = board[0].length;
        return row > 0 && row < N - 1 && col > 0 && col < M - 1 && !visited[row][col] && board[row][col] == 'O';
    }


}
