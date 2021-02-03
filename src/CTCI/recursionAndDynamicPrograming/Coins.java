package CTCI.recursionAndDynamicPrograming;

public class Coins {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(numWays(coins, amount));
    }

    private static int numWays(int[] coins, int N) {
        if (N == 0) return 1;
        if (N < 0) return 0;

        int ways = 0;
        for (int coin : coins){
            int remainingAmount = N - coin;
            if(remainingAmount >= 0)
                ways += numWays(coins, remainingAmount);
        }


        return ways;
    }


}
