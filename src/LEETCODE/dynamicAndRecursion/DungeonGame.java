package LEETCODE.dynamicAndRecursion;

import java.util.Arrays;

public class DungeonGame {
    public static void main(String[] args) {

        int[][] grid = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        System.out.println(calculateMinimumHP(grid));

    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int N = dungeon.length;
        int M = dungeon[0].length;

        int[][] lifeRem = new int[N + 1][M + 1];
        int[][] spentLife = new int[N + 1][M + 1];

        for (int row = 1; row <= N; row++) {
            int current = lifeRem[row - 1][1] + dungeon[row - 1][0];
            if (current < 0) {
                spentLife[row][1] = 1 + Math.abs(current) + spentLife[row - 1][1];
                lifeRem[row][1] = 1;
            } else {
                spentLife[row][1] = spentLife[row - 1][1];
                lifeRem[row][1] = current;
            }
        }


        for (int col = 1; col <= M; col++) {
            int current = lifeRem[1][col - 1] + dungeon[0][col - 1];
            if (current < 0) {
                spentLife[1][col] = 1 + Math.abs(current) + spentLife[1][col - 1];
                lifeRem[1][col] = 1;
            } else {
                spentLife[1][col] = spentLife[1][col - 1];
                lifeRem[1][col] = current;
            }
        }


        for (int row = 2; row <= N; row++) {

            for (int col = 2; col <= M; col++) {

                int i = 0;
                int j = 0;
                if (spentLife[row][col - 1] < spentLife[row - 1][col]) {
                    i = row;
                    j = col - 1;
                } else {
                    i = row - 1;
                    j = col;
                }

                int current = lifeRem[i][j] + dungeon[0][col - 1];
                if (current < 0) {
                    spentLife[row][col] = 1 + Math.abs(current) + spentLife[i][j];
                    lifeRem[row][col] = 1;
                } else {
                    spentLife[row][col] = spentLife[i][j];
                    lifeRem[row][col] = current;
                }

            }

        }


        for (int[] row : lifeRem)
            System.out.println(Arrays.toString(row));
        System.out.println("====================");
        for (int[] row : spentLife)
            System.out.println(Arrays.toString(row));


        return 0;
    }
}
