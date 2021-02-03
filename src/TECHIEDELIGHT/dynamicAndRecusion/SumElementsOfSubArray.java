package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

public class SumElementsOfSubArray {
    public static void main(String[] args) {

        int[][] mat =
                {
                        {0, 2, 5, 4, 1},
                        {4, 8, 2, 3, 7},
                        {6, 3, 4, 6, 2},
                        {7, 3, 1, 8, 3},
                        {1, 5, 7, 9, 4}
                };

        System.out.println(sumElementsOfSubArray(mat));

    }

    private static int sumElementsOfSubArray(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++)
            cache[row][0] = matrix[row][0];
        for (int col = 0; col < matrix[0].length; col++)
            cache[0][col] = matrix[0][col];

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                cache[row][col] = matrix[row][col] + cache[row - 1][col] + cache[row][col - 1] - cache[row - 1][col - 1];
            }
        }


        for (int[] col : cache)
            System.out.println(Arrays.toString(col));

        return 1;
    }
}
