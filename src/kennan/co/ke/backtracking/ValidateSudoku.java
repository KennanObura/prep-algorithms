package kennan.co.ke.backtracking;

public class ValidateSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();
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

        solution.isValidSudoku(grid);
    }

}

class Solution {


    public boolean isValidSudoku(char[][] board) {
        int sqrRoot = (int) Math.sqrt(board.length);
//        return isRowValid()
        return false;
    }


}
