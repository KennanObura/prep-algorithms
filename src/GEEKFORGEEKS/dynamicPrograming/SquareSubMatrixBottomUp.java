package GEEKFORGEEKS.dynamicPrograming;

public class SquareSubMatrixBottomUp {

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
        int[][] cache = new int[N + 1][M + 1];

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                if (grid[row - 1][col - 1]) {
                    cache[row][col] = Math.min(cache[row - 1][col],
                            Math.min(cache[row][col - 1], cache[row - 1][col - 1])) + 1;

                    maxSquare = Math.max(maxSquare, cache[row][col]);
                }
            }
        }
        return maxSquare;
    }


}
