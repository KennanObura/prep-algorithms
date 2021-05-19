package GEEKFORGEEKS.dynamicPrograming;

public class CoinChangeProblem {
    public static void main(String[] args) {


        int[] coins = {1, 5, 10, 25};
        System.out.println(makeChange(coins, 49));
    }


    private static int makeChange(int[] coins, int N) {
        if (N == 0) return 0;


        int minWays = Integer.MAX_VALUE;


//        for (int coin : coins) {
//
//            if (N - coin >= 0) {
//                int currMinCoins = makeChange(coins,N - coin)+1;
//                if (currMinCoins < minWays)
//                    minWays = currMinCoins;
//            }
//        }

//
        for (int coin : coins) {
            if (N - coin < 0)
                break;
            int current = makeChange(coins, N - coin) + 1;
            minWays = Math.min(current, minWays);
        }
//        System.out.println(minWays);


        return minWays;
    }
}
