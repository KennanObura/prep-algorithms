package TECHIEDELIGHT.dynamicAndRecusion;

public class HatCheckProblem {
    public static void main(String[] args) {

        System.out.println(derangements(4));
        System.out.println(derangementBottomUp(4));
    }


    public static int derangements(int n) {

        if (n == 1) return 0;
        if (n == 0) return 1;

        return (n - 1) * (derangements(n - 1) + derangements(n - 2));

    }


    public static int derangementBottomUp(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);

        }
        return dp[n];

    }


}
