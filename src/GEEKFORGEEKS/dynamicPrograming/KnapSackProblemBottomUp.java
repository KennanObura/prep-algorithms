package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;

public class KnapSackProblemBottomUp {

    public static void main(String[] args) {

        Item[] items = new Item[4];
        items[0] = new Item(6, 2);
        items[1] = new Item(10, 2);
        items[2] = new Item(12, 3);
        items[3] = new Item(13, 3);

        System.out.println(knapsack(items, 6));
    }


    private static int knapsack(Item[] items, int W) {
        int N = items.length;
        int[][] map = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {

                if (items[i - 1].weight > j)
                    map[i][j] = map[i - 1][j];
                else
                    map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - items[i - 1].weight] + items[i - 1].value);
            }
        }


        for (int[] row : map)
            System.out.println(Arrays.toString(row));
        return map[N][W];
    }


}


