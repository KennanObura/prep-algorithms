package kennan.co.ke.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to O.
 */
public class ZeroMatrixII {
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
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0)
                    map.put(i, j);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            setRowColToZero(matrix, entry.getKey(), entry.getValue());

        return matrix;
    }

    private static void setRowColToZero(int[][] matrix, Integer row, Integer col) {
        int i = 0;
        while (i < matrix.length)
            matrix[row][i++] = 0;

        i = 0;
        while (i < matrix[0].length)
            matrix[i++][col] = 0;
    }


}
