package TECHIEDELIGHT.dynamicAndRecusion;

public class KnapSack {
    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;

        System.out.println(knapSack(val, wt, W, 0));
    }

    /*
     *
     * NAIVE SOLUTION, runs 2 ^n
     */
    private static int knapSack(int[] value, int[] weight, int capacity, int index) {
        if (index < 0 || capacity < 0) return 0;

        /*
         * Proceed and return 0 if the current weight exceeds the current capacity
         */

        if (weight[index] > capacity)
            return knapSack(weight, value, capacity, index - 1);

        int includedResult = knapSack(weight, value, capacity - weight[index], index - 1) + value[index];

        int notIncludedResult = knapSack(weight, value, capacity, index - 1);

        return Math.max(includedResult, notIncludedResult);
    }
}
