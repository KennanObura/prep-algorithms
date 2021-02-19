package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {
    public static void main(String[] args) {

        int[][] matrix = {
                {1},
                {0},
                {1}
        };

        setZeroes(matrix);

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));


    }

    private static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void setZeroes(int[][] matrix) {

        int N = matrix.length;
        int M = matrix[0].length;
        List<Point> pointList = new ArrayList<>();

        for (int row = 0; row < N; row++)
            for (int col = 0; col < M; col++)
                if (matrix[row][col] == 0)
                    pointList.add(new Point(row, col));

        for (Point point : pointList)
            setToZero(matrix, point.i, point.j);

    }

    private static void setToZero(int[][] matrix, int row, int col) {
        int N = matrix.length;
        int M = matrix[0].length;

        int i = 0;
        while (i < M)
            matrix[row][i++] = 0;
        i = 0;
        while (i < N)
            matrix[i++][col] = 0;
    }
}
