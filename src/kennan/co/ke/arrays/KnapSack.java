package kennan.co.ke.arrays;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
public class KnapSack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;

        System.out.println(maximumValueInKnapSack(val, wt, W));
    }

    private static int maximumValueInKnapSack(int[] val, int[] wt, int w) {
        return maximumValueInKnapSack(val, wt, w, val.length - 1);
    }

    private static int maximumValueInKnapSack(int[] val, int[] wt, int w, int i) {
        if (i == val.length || w == 0)
            return 0;

        if (wt[i] > w)
            return maximumValueInKnapSack(val, wt, w, i + 1);

        int included = maximumValueInKnapSack(val, wt, w - wt[i], i + 1) + val[i];
        int notIncluded = maximumValueInKnapSack(val, wt, w, i + 1);
        return Math.max(included, notIncluded);
    }
}
