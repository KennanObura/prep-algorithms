package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;

public class SquareSubMatrix {

    public static void main(String[] args) {
        boolean[][] mat = {
                {false, true, false, false},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, false}
        };

        boolean[][] matII = {
                {false, true, false, true, true, true, true},
                {true, true, true, true, true, true, true},
                {true, true, true, true, false, true, true},
                {true, true, true, true, true, true, true},
                {true, true, false, true, true, true, true},
                {true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true},
        };


        System.out.println(squareSubMatrix(mat));
        System.out.println(squareSubMatrix(matII));
    }

    private static int squareSubMatrix(boolean[][] grid) {

        int N = grid.length, M = grid[0].length, maxSquare = Integer.MIN_VALUE;
        int[][] cache = new int[N][M];

        for (int[] row : cache)
            Arrays.fill(row, -1);


        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (grid[row][col])
                    maxSquare = Math.max(maxSquare,
                            getSquareLength(grid, row, col, cache));
            }
        }


        for (int[] row : cache)
            System.out.println(Arrays.toString(row));

        return maxSquare;
    }

    private static int getSquareLength(boolean[][] grid, int row, int col, int[][] cache) {

        if (row >= grid.length || col >= grid[0].length || !grid[row][col])
            return 0;

        if (cache[row][col] < 0) {


            int left = getSquareLength(grid, row, col + 1, cache) + 1;
            int down = getSquareLength(grid, row + 1, col, cache) + 1;
            int diagonal = getSquareLength(grid, row + 1, col + 1, cache) + 1;

            cache[row][col] = Math.min(left, Math.min(diagonal, down));
        }

        return cache[row][col];
    }
}
