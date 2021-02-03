package kennan.co.ke.dynamicProgramingAndRecussion;

public class CoinChangeProblem {
    public static void main(String[] args) {

    }

    private static int solve(int[] coins, int N) {
        int[] ways = new int[N + 1];

        ways[0] = 1;
        for (int coin : coins)
            for (int i = 0; i <= N; i++) {
                if (coin <= i)
                    ways[i] += ways[i - coin];
            }
        return ways[N];
    }
}
