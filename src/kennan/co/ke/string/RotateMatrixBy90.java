package kennan.co.ke.string;

public class RotateMatrixBy90 {
    public static void main(String[] args) {

    }

    private static int[][] rotate(int[][] matrix) {
        if (matrix.length != matrix[0].length) throw new RuntimeException("Matrix is not a square");

        int size = matrix.length;

        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - i - 1; j++) {
                matrix[i][j] = swap(matrix[j][size - j - 1], matrix[j][size - j - 1] = matrix[i][j]);
                matrix[j][size - j - 1] = swap(matrix[i][size - i - 1], matrix[j][size - j - 1] = matrix[i][size-j-1]);
                matrix[i][j] = swap(matrix[j][size - j - 1], matrix[j][size - j - 1] = matrix[i][j]);
                matrix[i][j] = swap(matrix[j][size - j - 1], matrix[j][size - j - 1] = matrix[i][j]);
            }
        }
        return matrix;
    }

    private static int swap(int i, int j) {
        return i;
    }
}
