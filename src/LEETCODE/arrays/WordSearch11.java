package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 212. Word Search II
 * Hard
 * <p>
 * 3411
 * <p>
 * 141
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */

public class WordSearch11 {
    public static void main(String[] args) {

        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

//        char[][] board2 = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'E', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String word2 = "ABCESEEEFST";

        System.out.println(findWords(board, words));
//        System.out.println(exist(board2, word2));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> stringList = new ArrayList<>();
        for (String word : words)
            if (exist(board, word))
                stringList.add(word);

        return stringList;
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

        if (!right && !left && !up && !down) {
            visited[row][col] = false;
            return false;
        } else return true;
    }
}
