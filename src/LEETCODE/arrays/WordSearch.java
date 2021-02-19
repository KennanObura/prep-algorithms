package LEETCODE.arrays;

import java.util.Arrays;

/**
 * /**
 *  * 79. Word Search
 *  * Medium
 *  * Given an m x n board and a word, find if the word exists in the grid.
 *  *
 *  * The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *  * Example 1:
 *  *
 *  *
 *  * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *  * Output: true
 *  */


public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word2 = "ABCESEEEFST";

        System.out.println(exist(board, word));
        System.out.println(exist(board2, word2));
    }

    public static boolean exist(char[][] board, String word) {
        int N = board.length;
        int M = board[0].length;

        boolean[][] visited;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (word.charAt(0) == board[row][col]) {
                    visited = new boolean[N][M];
                    if (wordFound(board, visited, row, col, word, 0))
                        return true;
                    for (boolean [] c : visited)
                        System.out.println(Arrays.toString(c));
                }

            }
        }
        return false;
    }

    private static boolean wordFound(char[][] board, boolean[][] visited, int row, int col, String word, int i) {
        int N = board.length;
        int M = board[0].length;
        int wordL = word.length();
        if (i == wordL) return true;

        if (row < 0 || row >= N || col < 0 || col >= M || visited[row][col] || word.charAt(i) != board[row][col])
            return false;


        visited[row][col] = true;

        boolean right = wordFound(board, visited, row, col + 1, word, i + 1);

        boolean left = wordFound(board, visited, row, col - 1, word, i + 1);

        boolean up = wordFound(board, visited, row - 1, col, word, i + 1);

        boolean down = wordFound(board, visited, row + 1, col, word, i + 1);

        if(!right && !left && !up && !down) {
            visited[row][col] = false;
            return false;
        }
        else return true;
    }
}
