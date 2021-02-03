package kennan.co.ke.backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
/*
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]



Output
 [["5","3","1","2","7","6","9","4","8"],
 ["6","4","7","1","9","5","8","3","2"],
 ["2","9","8","5","3","7","1","6","4"],
 ["8","1","9","7","6","2","4","5","3"],
 ["4","7","2","8","5","3","6","9","1"],
 ["7","5","4","9","2","8","3","1","6"],
 ["9","6","5","3","4","1","2","8","7"],
 ["3","8","6","4","1","9","7","2","5"],
 ["1","2","3","6","8","4","5","7","9"]]
 */

        char[][] grid = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Sodoku sodoku = new Sodoku(grid);
        sodoku.solve();
    }

}

class Sodoku {
    final char[][] board;
    final int length;

    Sodoku(char[][] board) {
        this.board = board;
        this.length = board.length;
    }

    void solve() {
        if (length < 9) return;

        if (isFullySolved()) printBoard();

//        printBoard();
    }

    private void printBoard() {
        for (char[] col : board)
            System.out.println(Arrays.toString(col));
    }


    private boolean isFullySolved() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= length; k++) {
                        char num = (char) (k + 48);
                        if (isSafeToPlace(i, j, num)) {
                            board[i][j] = num;
                            if (isFullySolved()) return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isSafeToPlace(int row, int col, int num) {
        return isRowSafe(row, num) && isColumnSafe(col, num) && isBoxSafe(row, col, num);
    }

    private boolean isBoxSafe(int row, int col, int num) {
        int sqrRoot = (int) Math.sqrt(length);
        int columnStart = col - (col % sqrRoot);
        int rowStart = row - (row % sqrRoot);

        int columnEnd = columnStart + sqrRoot;
        int rowEnd = rowStart + sqrRoot;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = columnStart; j < columnEnd; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    private boolean isColumnSafe(int col, int num) {
        int row = 0;
        while (row < length)
            if (board[row++][col] == num) return false;
        return true;
    }

    private boolean isRowSafe(int row, int num) {
        int col = 0;
        while (col < length)
            if (board[row][col++] == num) return false;
        return true;
    }
}
