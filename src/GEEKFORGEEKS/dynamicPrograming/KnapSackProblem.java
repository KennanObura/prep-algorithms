package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KnapSackProblem {

    public static void main(String[] args) {

        Item[] items = new Item[4];
        items[0] = new Item(6, 2);
        items[1] = new Item(10, 2);
        items[2] = new Item(12, 3);
        items[3] =  new Item(13, 3);

        System.out.println(knapsack(items, 6));
    }


    private static int knapsack(Item[] items, int W) {
        int[][] map = new int[items.length][W+1];

        for (int[] row : map)
            Arrays.fill(row, -1);
        int result = knapsack(items, W, items.length - 1, map);


        for (int[] row : map)
            System.out.println(Arrays.toString(row));
        return result;
    }

    private static int knapsack(Item[] items, int W, int i, int[][] map) {
        if (i < 0 || W == 0) return 0;

        if (W - items[i].weight < 0)
            return knapsack(items, W, i - 1, map);

        if (map[i][W] < 0) {

            int include = knapsack(items, W - items[i].weight, i - 1, map) + items[i].value;
            int exclude = knapsack(items, W, i - 1, map);

            map[i][W] = Math.max(include, exclude);
        }
        return map[i][W];
    }
}

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
