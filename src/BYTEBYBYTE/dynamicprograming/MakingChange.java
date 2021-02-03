package BYTEBYBYTE.dynamicprograming;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * eg. (assuming American coins: 1, 5, 10, and 25 cents)
 * makeChange(1) = 1 (1)
 * makeChange(6) = 2 (5 + 1)
 * makeChange(49) = 7 (25 + 10 + 10 + 1 + 1 + 1 + 1)
 * <p>
 * <p>
 * NAIVE SOLUTION
 * Recursively,
 * Find every possible combination that can be made using coins
 * At every C, coin is only a candidate when its >= than C
 * <p>
 * <p>
 * IMPROVED SOLUTION : Dynamic programing
 * ===============================================
 * Build a table , starting from 0 ..C
 * We find out how many coins can be used to make up C at every ith Position
 * <p>
 * indices [0, 1, 2, 3,4,5,6,7,8,9,10]
 * no. coins 1 [1,1,1,1,1,1,1,1,1,1,1]
 * no. coins 2 [1,1,1,1,1,1,2,2,2,2,2]
 * <p>
 * no. coins 3 [1,1,1,1,1,1,2,2,2,2,4]
 * <p>
 * the 10th is filled with 4, since the previous value was 2,
 * 10 - 5 => 5 , the value at 5th => 2
 * 2+2 = 4
 * <p>
 * totalCoins[i] = totalCoins[i]+totalCoins[C-i]
 */

public class MakingChange {
    public static void main(String[] args) {
        int[] coins = {2};

//        System.out.println(numberOfCoins(coins, 11));
        System.out.println(numberOfCoinMemoized(coins, 3));
        System.out.println(numberOfCoinTopDown(coins, 3));

    }


    private static int numberOfCoins(int[] coins, int C) {

        if (C <= 0) return 0;

        int total = Integer.MAX_VALUE;

        for (int coin : coins)
            if (C - coin >= 0) {
                int current = numberOfCoins(coins, (C - coin));
                total = Math.min(total, current);
            }

        return total + 1;
    }

    /*

    Bottom up solution
     */

    private static int numberOfCoinMemoized(int[] coins, int C) {

        int[] totalCoins = new int[C + 1];
        Arrays.fill(totalCoins, C + 1);

        totalCoins[0] = 0;

        for (int coin : coins)
            for (int i = 1; i <= C; i++) {
                if (i - coin >= 0) {
                    totalCoins[i] = Math.min(totalCoins[i], totalCoins[i - coin] + 1);
                    System.out.println(Arrays.toString(totalCoins));
                }
            }
        return totalCoins[C] >= C + 1 ? -1 : totalCoins[C];

    }

    /*
    Top down solution
     */

    private static int numberOfCoinTopDown(int[] coins, int C) {
        int[] cache = new int[C + 1];
        Arrays.fill(cache, -1);
//        cache[0] = 0;
        return numberOfCoinTopDown(coins, C, cache);
    }

    private static int numberOfCoinTopDown(int[] coins, int C, int[] cache) {

        if (cache[C] >= 0) return cache[C];
        int min = Integer.MAX_VALUE;
        for (int coin : coins)
            if (C - coin >= 0) {
                int currentMin = numberOfCoinTopDown(coins, C - coin, cache);
                min = Math.min(min, currentMin);
            }
        System.out.println(min);
        cache[C] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        return cache[C];
    }
}
