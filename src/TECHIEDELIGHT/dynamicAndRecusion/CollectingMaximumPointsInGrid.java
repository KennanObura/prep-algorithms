package TECHIEDELIGHT.dynamicAndRecusion;

public class CollectingMaximumPointsInGrid {
    public static void main(String[] args) {

    }

    private static int collectMaximumPoints(int[][] matrix) {

        int maxPoints = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++)
            if (matrix[row][0] != -1)
                maxPoints = Math.max(maxPoints, collectMaximumPoints(matrix, row, 0, 0));

        for (int col = 0; col < matrix[0].length; col++)
            if (matrix[0][col] != -1)
                maxPoints = Math.max(maxPoints, collectMaximumPoints(matrix, 0, col, 0));
        return maxPoints;
    }

    private static int collectMaximumPoints(int[][] matrix, int row, int col, int count) {
        if (row >= matrix.length - 1 || col >= matrix[0].length || row < 0 || col < 0) return count;

        int moveLeft;
        int moveRight;

        if (isSafeToMove(matrix, row, col)) {
            count += collectMaximumPoints(matrix, row+1, col, count) + matrix[row][col];

            if (row % 2 != 0) {
                moveLeft = collectMaximumPoints(matrix, row, col - 1, count) + matrix[row][col];
            } else
                moveRight = collectMaximumPoints(matrix, row, col + 1, count) + matrix[row][col];

//            count = Math.max(moveLeft, moveRight);
        }

        return count;
    }

    private static boolean isSafeToMove(int[][] matrix, int row, int col) {
        return matrix[row][col] != -1;
    }
}
