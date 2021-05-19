package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;

public class CoinChangeProblemTopDown {
    public static void main(String[] args) {


        int[] coins = {1, 5, 10, 25};
        System.out.println(makeChange(coins, 49));
    }


    private static int makeChange(int[] coins, int N) {
        int[] cache = new int[N + 1];

        Arrays.fill(cache, -1);
        cache[0] = 0;

        int result =  makeChange(coins, N, cache);
        System.out.println(Arrays.toString(cache));
        return result;
    }

    private static int makeChange(int[] coins, int N, int[] cache) {
        if (N == 0) return 0;
        if (cache[N] >= 0)
            return cache[N];

        int minChange = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > N) continue;
            int currChange = makeChange(coins, N - coin, cache) + 1;
           minChange = Math.min(minChange, currChange);
        }
        cache[N] = minChange;
        return cache[N];

    }
}
