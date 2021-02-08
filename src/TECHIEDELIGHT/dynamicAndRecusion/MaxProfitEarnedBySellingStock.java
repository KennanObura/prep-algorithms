package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

public class MaxProfitEarnedBySellingStock {
    public static void main(String[] args) {

        int[] X = {5, 3, 4, 6, 3};
        int[] Y = {8, 4, 3, 5, 10};
        System.out.println(maxProfit(X, Y));

    }

    private static int maxProfit(int[] x, int[] y) {
        int [] lookup = new int[x.length];
        Arrays.fill(lookup, -1);
        int result =  maxProfit(x, y, x.length-1, lookup);
        System.out.println(Arrays.toString(lookup));
        return result;
    }

    private static int maxProfit(int[] X, int[] Y, int N, int [] lookup) {
        if(N < 0) return 0;

        if(lookup[N] != -1)
            return lookup[N];


        int sellX = maxProfit(X, Y, N-1, lookup) + X[N];

        int sellY = maxProfit(X, Y, N-2, lookup) + Y[N];

        lookup[N] = Math.max(sellY, sellX);

        return lookup[N];
    }
}
