package LEETCODE.dynamicAndRecursion;

import java.util.Arrays;

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 */
public class MaximalSquare {
    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        char[][] matrix2 = {{'1', '0'}, {'1', '1'}};

        char[][] matrix3 = {{'0'}};

        char[][] matrix4 = {{}};

        char[][] matrix5 = {{'0', '0'}};

        char[][] matrix6 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare(matrix2));
        System.out.println(maximalSquare(matrix3));
        System.out.println(maximalSquare(matrix4));
        System.out.println(maximalSquare(matrix5));
        System.out.println(maximalSquare(matrix6));
    }

    static private int maximalSquare(char[][] matrix) {
        int[][] area = new int[matrix.length + 1][matrix[0].length + 1];

        char CHAR_ZERO = '0';

        int maximalArea = Integer.MIN_VALUE;
        for (int row = 1; row < area.length; row++) {
            for (int col = 1; col < area[0].length; col++) {
                if (matrix[row - 1][col - 1] == CHAR_ZERO) continue;
                area[row][col] = 1 + Math.min(Math.min(area[row - 1][col], area[row][col - 1]), area[row - 1][col - 1]);
                maximalArea = Math.max(maximalArea, area[row][col] * area[row][col]);
            }
        }


        return maximalArea == Integer.MIN_VALUE ? 0 : maximalArea;

    }
}
