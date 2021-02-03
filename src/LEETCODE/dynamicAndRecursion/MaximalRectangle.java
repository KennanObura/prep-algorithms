package LEETCODE.dynamicAndRecursion;

import java.util.Arrays;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 */
public class MaximalRectangle {
    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '0'}
        };

        char[][] matrix2 = {{'1', '1'}, {'1', '1'}};

        char[][] matrix3 = {{'1'}};

        char[][] matrix4 = {};

        char[][] matrix5 = {{'0', '0'}};

        char[][] matrix6 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
//        System.out.println(maximalRectangle(matrix2));
//        System.out.println(maximalRectangle(matrix3));
//        System.out.println(maximalRectangle(matrix4));
//        System.out.println(maximalRectangle(matrix5));
//        System.out.println(maximalRectangle(matrix6));
    }

    static private int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        Pair[][] rect = new Pair[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < rect.length; i++)
            rect[i][0] = new Pair(0, 0);


        for (int i = 0; i < rect[0].length; i++)
            rect[0][i] = new Pair(0, 0);

        char CHAR_ZERO = '0';

        int maximalRect = Integer.MIN_VALUE;
        for (int row = 1; row < rect.length; row++) {

            for (int col = 1; col < rect[0].length; col++) {
                Pair point = new Pair(0, 0);


                if (matrix[row - 1][col - 1] == CHAR_ZERO) {
                    rect[row][col] = point;
                    continue;
                }


//                if (col - 2 > 0 && rect[row][col - 1].col > 0 && rect[row][col - 2].col == 0)
//                    point.col = rect[row][col - 1].col - 1;
//
//                else if (row - 2 > 0 && rect[row - 1][col].row > 0 && rect[row - 2][col].row == 0)
//                    point.row = rect[row - 1][col].col - 1;


                    point.row = rect[row - 1][col].row + 1;
                    point.col = rect[row][col - 1].col + 1;

                rect[row][col] = point;

                maximalRect = Math.max(maximalRect, (point.row * point.col));
            }
        }


        for (Pair[] col : rect)
            System.out.println(Arrays.toString(col));

        return maximalRect == Integer.MIN_VALUE ? 0 : maximalRect;

    }

    private static class Pair {
        int row = 0;
        int col = 0;

        Pair(int length, int width) {
            this.row = length;
            this.col = width;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "" + row +
                    "," + col +
                    '}';
        }
    }
}
