package TUTORIALHORIZON.backtracking;

import java.util.Arrays;

/**
 * Objective : Given a 2D matrix of characters. Check whether the word exist in the matrix or not.
 * If it exists then print its path.
 * All movements are allowed (right, left, up, down and diagonally).
 */
public class SearchWordInMatrix {
    public static void main(String[] args) {
        char[][] matrix = {
                {'t', 'z', 'x', 'c', 'd'},
                {'a', 'h', 'n', 'z', 'x'},
                {'h', 'w', 'o', 'i', 'o'},
                {'o', 'r', 'n', 'r', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };
        WordMatrix w = new WordMatrix(matrix.length, matrix[0].length);
        if (w.searchWord(matrix, "horizon")) {
            w.print();
        } else {
            System.out.println("NO PATH FOUND");
        }
    }
}

class WordMatrix {
    private final int N;
    private final int M;
    private final int[][] result;
    private int PATH;

    WordMatrix(int N, int M) {
        this.N = N;
        this.M = M;
        this.result = new int[N][M];
        this.PATH = 0;
    }


    public boolean searchWord(char[][] matrix, String horizon) {


        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                char firstChar = horizon.charAt(0);
                if (firstChar == matrix[row][col])
                    if (searchWord(matrix, horizon, row, col, 0))
                        return true;

            }

        }
        return false;
    }

    private boolean searchWord(char[][] matrix, String horizon, int row, int col, int index) {
        if (row < 0 || row >= N || col < 0 || col >= M || result[row][col] != 0 || matrix[row][col] != horizon.charAt(index))
            return false;



        PATH++;
        result[row][col] = PATH;

        if (index == horizon.length() - 1)
            return true;

        if (searchWord(matrix, horizon, row + 1, col, index + 1))
            return true;

        if (searchWord(matrix, horizon, row - 1, col, index + 1))
            return true;

        if (searchWord(matrix, horizon, row, col + 1, index + 1))
            return true;

        if (searchWord(matrix, horizon, row, col - 1, index + 1))
            return true;

        if (searchWord(matrix, horizon, row + 1, col + 1, index + 1))
            return true;

        if (searchWord(matrix, horizon, row + 1, col - 1, index + 1))
            return true;

        if (searchWord(matrix, horizon, row - 1, col + 1, index + 1))
            return true;

        if (searchWord(matrix, horizon, row - 1, col - 1, index + 1))
            return true;

        PATH--;
        result[row][col] = 0;
        return false;
    }

    public void print() {
        for (int[] row : result)
            System.out.println(Arrays.toString(row));
    }
}
