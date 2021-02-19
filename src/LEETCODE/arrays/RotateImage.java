package LEETCODE.arrays;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(matrix);

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));


    }


    public static void rotate(int[][] matrix) {

        transpose(matrix);
        reverse(matrix);

    }

    private static void transpose(int[][] matrix) {
        int N = matrix.length;
        for (int row = 0; row < N; row++)
            for (int col = row; col < N; col++)
                matrix[row][col] = swap(matrix[col][row], matrix[col][row] = matrix[row][col]);
    }

    private static void reverse(int[][] matrix) {
        int N = matrix.length;
        for (int row = 0; row < N; row++)
            for (int col = 0; col < N/ 2; col++)
                matrix[row][col] = swap(matrix[row][N-col-1], matrix[row][N-col-1] = matrix[row][col]);
    }

    private static int swap(int matrix, int i) {
        return matrix;
    }
}
