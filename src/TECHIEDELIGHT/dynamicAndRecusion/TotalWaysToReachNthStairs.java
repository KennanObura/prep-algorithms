package TECHIEDELIGHT.dynamicAndRecusion;

public class TotalWaysToReachNthStairs {
    public static void main(String[] args) {

        System.out.println(ways(4,3));
    }


    private static int ways(int N, int M) {
        if (N < 0) return 0;
        if (N == 1 || N == 0) return 1;

        int currentWays = 0;
        for (int i = 1; i <= M; i++) {
            currentWays += ways(N - i, M);
        }

        return currentWays;
    }
}
