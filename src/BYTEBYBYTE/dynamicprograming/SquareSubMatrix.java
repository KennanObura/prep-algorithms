package BYTEBYBYTE.dynamicprograming;

/**
 * Given a 2D boolean array, find the largest square subarray of
 * true values. The return value should be the side length of the
 * largest square subarray subarray.
 * <p>
 * arr {
 * {false, true, false, false},
 * {true, true, true, true},
 * {false, true, false, false},
 * {false, true, true, false}
 * <p>
 * }
 * <p>
 * output = 2;
 */
public class SquareSubMatrix {
    public static void main(String[] args) {
        boolean[][] mat = {
                {false, true, false, false},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, false}
        };

        System.out.println(squareSubMatrix(mat));
        System.out.println(squareSubMatrixUtilDP(mat));
    }

    private static int squareSubMatrix(boolean[][] matrix) {

        int maxLength = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col])
                    maxLength = Math.max(maxLength, squareSubMatrixUtil(matrix, row, col));
            }
        }
        return maxLength;
    }


    private static int squareSubMatrixUtil(boolean[][] matrix, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) return 0;

        if (!matrix[row][col]) return 0;

        int moveLeft = squareSubMatrixUtil(matrix, row + 1, col) + 1;
        int moveDown = Math.min(squareSubMatrixUtil(matrix, row, col + 1) + 1, moveLeft);


        return Math.min(moveDown, squareSubMatrixUtil(matrix, row + 1, col + 1) + 1);
    }


    private static int squareSubMatrixUtilDP(boolean[][] matrix) {
        int[][] cache = new int[matrix.length + 1][matrix[0].length + 1];

        for (int row = 1; row < cache.length; row++)
            for (int col = 1; col < cache[0].length; col++)
                if (matrix[row - 1][col - 1])
                    cache[row][col] = 1;

        int maxLength = Integer.MIN_VALUE;
        for (int row = 1; row < cache.length; row++) {
            for (int col = 1; col < cache[0].length; col++) {
                if (!matrix[row - 1][col - 1]) continue;
                cache[row][col] += Math.min(Math.min(cache[row - 1][col], cache[row][col - 1]),
                        cache[row - 1][col - 1]);
                maxLength = Math.max(maxLength, cache[row][col]);
            }
        }
        return maxLength;
    }


//    private static int squareSubMatrixUtil(boolean[][] matrix, int row, int col) {
//
//
//        int i = row;
//        int j = col;
//
//        int length = Integer.MAX_VALUE;
//        int count = 1;
//        while (j < matrix[0].length && matrix[i][j++])
//            count++;
//
//
//        length = Math.min(length, count - 1);
//
//        count = 1;
//        j = col;
//        while (i < matrix.length && matrix[i++][j])
//            count++;
//
//
//        length = Math.min(length, count - 1);
//
//        count = 1;
//        i = row;
//        j = col;
//        while (i < matrix.length && j < matrix[0].length && matrix[i++][j++])
//            count++;
//
//
//        length = Math.min(length, count - 1);
//
//
//        return length;
//    }


}
