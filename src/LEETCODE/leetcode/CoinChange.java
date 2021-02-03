package LEETCODE.leetcode;

public class CoinChange {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(change(amount, coins));
        System.out.println(changeRecur(amount, coins));

    }

    public static int change(int amount, int[] coins) {
        if (amount == 0) return 1;

        int[] cache = new int[amount + 1];

        cache[0] = 1;

        for (int coin : coins)
            for (int i = 1; i <= amount; i++)
                if (i >= coin)
                    cache[i] += cache[i - coin];
        return cache[amount];

    }




    public static int changeRecur(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        return changeRecur(amount - coins[0], coins) +
                changeRecur(amount - coins[1], coins) +
                changeRecur(amount - coins[2], coins);

    }
}
