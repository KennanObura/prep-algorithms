package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

public class KnapSackTopDown {
    public static void main(String[] args) {

        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(knapSackDP(wt, val, W));

    }

    /**
     * We use DP , developed from solution 1 @KnapSack,
     * Note that only two things change, @param capacity or index,
     * <p>
     * - build a 2d table to store calculated result,
     * return result if already calculated
     * <p>
     * Otherwise calculate and store;
     *
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    private static int knapSackDP(int[] weight, int[] value, int capacity) {
        int[][] cache = new int[weight.length][capacity + 1];
        int result = knapSackDP(weight, value, capacity, weight.length - 1, cache);

        for (int[] col : cache)
            System.out.println(Arrays.toString(col));
        return result;
    }


    private static int knapSackDP(int[] weight, int[] value, int capacity, int index, int[][] cache) {

        if (index < 0 || capacity < 0) return 0;


        if (cache[index][capacity] > 0) return cache[index][capacity];

        /*
         * Proceed and return 0 if the current weight exceeds the current capacity
         */

        if (weight[index] > capacity)
            return knapSackDP(weight, value, capacity, index - 1, cache);

        int includedResult = knapSackDP(weight, value, capacity - weight[index], index - 1, cache) + value[index];

        int notIncludedResult = knapSackDP(weight, value, capacity, index - 1, cache);

        cache[index][capacity] = Math.max(includedResult, notIncludedResult);


        return cache[index][capacity];

    }
}
