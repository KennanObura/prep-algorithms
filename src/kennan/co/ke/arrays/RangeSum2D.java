package kennan.co.ke.arrays;

import java.util.Arrays;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper
 * left corner (row1, col1) and lower right corner (row2, col2).
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */

public class RangeSum2D {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };


        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
    }

}

class NumMatrix {

    final int[][] matrix;
    final int[][] dbSums;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.dbSums = new int[matrix.length][matrix[0].length];
        createDbOfSum();

        for (int[] nums : dbSums)
            System.out.println(Arrays.toString(nums));
    }

    private void createDbOfSum() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                /*
                 *create sum of upper row
                 * create sum of left column
                 * create sum of the intersections
                 */
                if (i == 0) {
                    if (j == 0) dbSums[i][j] = matrix[i][j];
                    else dbSums[i][j] = matrix[i][j] + dbSums[i][j - 1];
                } else if (j == 0)
                    dbSums[i][j] = dbSums[i - 1][j] + matrix[i][j];
                else dbSums[i][j] = matrix[i][j] + dbSums[i - 1][j] + dbSums[i][j - 1] - dbSums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = dbSums[row2][col2];
        totalSum -= dbSums[row2][col1 - 1];
        totalSum -= dbSums[row1 - 1][col2];
        totalSum += dbSums[row1 - 1][col1 - 1];
        return totalSum;

    }
}
