package kennan.co.ke.string;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to O.
 */
public class ZeroMatrix {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 15, 16}
        };

        int[][] result = solve(mat);

        for (int[] ints : result) {
            for (int x : ints)
                System.out.print(x + " , ");
            System.out.println();
        }
    }

    private static int[][] solve(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }

        setRowToZero(matrix, rows);
        setColToZero(matrix, cols);

        return matrix;
    }

    private static void setColToZero(int[][] matrix, int[] cols) {
        for (int i = 0; i < cols.length; i++)
            if (cols[i] == 1) nullifyCol(matrix, i);
    }

    private static void nullifyCol(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++)
            matrix[j][i] = 0;
    }

    private static void setRowToZero(int[][] matrix, int[] rows) {
        for (int i = 0; i < rows.length; i++)
            if (rows[i] == 1) nullifyRow(matrix, i);
    }

    private static void nullifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++)
            matrix[i][j] = 0;
    }

}
