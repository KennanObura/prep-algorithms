package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which
 * the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * He can move only (right->,right up /,right down\) that is from a given cell,
 * the miner can move to the cell diagonally up towards the right or right or diagonally down
 * towards the right. Find out maximum amount of gold he can collect.
 * <p>
 * Examples:
 * <p>
 * Input : mat[][] = {{1, 3, 3},
 * {2, 1, 4},
 * {0, 6, 4}};
 * Output : 12
 * {(1,0)->(2,1)->(2,2)}
 * <p>
 * Input: mat[][] = { {1, 3, 1, 5},
 * {2, 2, 4, 1},
 * {5, 0, 2, 3},
 * {0, 6, 1, 2}};
 * Output : 16
 * (2,0) -> (1,1) -> (1,2) -> (0,3) OR
 * (2,0) -> (3,1) -> (2,2) -> (2,3)
 * <p>
 * Input : mat[][] = {{10, 33, 13, 15},
 * {22, 21, 04, 1},
 * {5, 0, 2, 3},
 * {0, 6, 14, 2}};
 * Output : 83
 */
public class GoldMineProblemBottomUp {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };

        int[][] mat1 = {
                {10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}
        };

//        System.out.println(maximumGold(mat));
        System.out.println(maximumGold(mat1));

    }

    private static int maximumGold(int[][] matrix) {

        int maximumA = Integer.MIN_VALUE;
        int[][] cache = new int[matrix.length + 1][matrix[0].length + 1];

        for (int row = 1; row <= matrix.length; row++) {
            for (int col = 1; col <= matrix[0].length; col++) {

                int prevLeft = cache[row][col - 1];
                int prevDown = row + 1 < matrix.length ? cache[row + 1][col - 1] : 0;
                int prevUp = cache[row - 1][col - 1];


                cache[row][col] = matrix[row - 1][col - 1] + Math.max(prevLeft, Math.max(prevDown, prevUp));

            }
//            maximumA = Math.max(maximumA, currentAmount);
        }

        for(int [] col : cache)
            System.out.println(Arrays.toString(col));

        return cache[matrix.length][matrix[0].length];
    }


}
