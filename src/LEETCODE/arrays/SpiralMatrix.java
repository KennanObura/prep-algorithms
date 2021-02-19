package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Medium
 * Share
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] matrix3 = {
                {1},
                {5},
                {9}
        };

        int[][] matrix4 = {
                {1},
        };

        System.out.println(spiralOrder(matrix));

        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
        System.out.println(spiralOrder(matrix4));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i : matrix[0])
                result.add(i);
            return result;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        spiralOrder(matrix, 0, 0, visited, result);
        return result;
    }

    private static void spiralOrder(int[][] matrix, int row, int col, boolean[][] visited, List<Integer> result) {
        int N = matrix.length;
        int M = matrix[0].length;

        if (row < 0 || row >= N || col < 0 || col >= M) return;

        int j = col;
        int i = row;

        while (j < M - 1 && !visited[i][j]) {
            result.add(matrix[i][j]);
            visited[i][j++] = true;
        }


        while (i < N - 1 && !visited[i][j]) {
            result.add(matrix[i][j]);
            visited[i++][j] = true;
        }


        while (j > col && !visited[i][j]) {
            result.add(matrix[i][j]);
            visited[i][j--] = true;
        }


        while (i > row && !visited[i][j]) {
            result.add(matrix[i][j]);
            visited[i--][j] = true;
        }

        spiralOrder(matrix, row + 1, col + 1, visited, result);

    }
}
