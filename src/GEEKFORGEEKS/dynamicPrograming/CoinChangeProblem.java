package GEEKFORGEEKS.dynamicPrograming;

public class CoinChangeProblem {
    public static void main(String[] args) {


        int[] coins = {1, 5, 10};
        System.out.println(makeChange(coins, 10));
    }

//    private static int makeChange(int[] coins, int N) {
//
//        int count = 0;
//        for (int i = 1; i <= N; i++) {
//            count = 0;
//            for (int coin : coins)
//                if (i - coin >= 0)
//                    count++;
//            System.out.println(count);
//
//
//        }
//        return count;
//    }

    private static int makeChange(int[] coins, int N) {
        if (N == 0) return 0;


        int minWays = Integer.MAX_VALUE;


        for (int coin : coins) {

            if (N - coin >= 0) {
                int currMinCoins = makeChange(coins,N - coin);
                if (currMinCoins < minWays)
                    minWays = currMinCoins;
            }
        }

//
//        for (int coin : coins)
//            if (N - coin >= 0)
//                minWays = Math.min(makeChange(coins, N - coin), minWays);
//        System.out.println(minWays);


        return minWays + 1;
    }
}
