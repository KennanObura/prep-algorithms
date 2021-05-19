package GEEKFORGEEKS.dynamicPrograming;

import java.util.Arrays;

public class CoinChangeProblemBottomUp {
    public static void main(String[] args) {


        int[] coins = {1, 5, 10, 25};
        System.out.println(makeChange(coins, 49));
    }


    private static int makeChange(int[] coins, int N) {
        int[] cache = new int[N + 1];

        Arrays.fill(cache, -1);
        cache[0] = 0;

        for (int i = 1; i <= N; i++) {

            int minChange = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) continue;

                minChange = Math.min(minChange, cache[i - coin] + 1);
            }

            cache[i] = minChange;

        }


        System.out.println(Arrays.toString(cache));
        return cache[N];
    }


}
