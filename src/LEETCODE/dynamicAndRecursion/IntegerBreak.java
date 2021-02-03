package LEETCODE.dynamicAndRecursion;

/**
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {
    public static void main(String[] args) {
//        System.out.println(integerBreak(10));
        System.out.println(integerBreakDP(3));
    }

    private static int integerBreak(int n) {
        if (n <= 1) return 1;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {

            int currentProd = integerBreak(n - i) * i;
            max = Math.max(currentProd, max);
        }
        return max;

    }


    private static int integerBreakDP(int n) {
        if (n == 2 || n == 3) return n - 1;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;


        for (int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) { //cutting at i positions and checking
                max = Math.max(max, j * cache[i - j]);
            }
            cache[i] = max;
        }




        return cache[n];

    }

    public int integerBreak(int n, int k) {
        if (n == 2 || n == 3) return n - 1;

        int dp[] = new int[n + 1];

        int q; // temporary max value

        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j <= n; j++) {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) { //cutting at i positions and checking
                q = Math.max(q, i * dp[j - i]);
            }
            dp[j] = q;
        }

        return dp[n];

    }

}
