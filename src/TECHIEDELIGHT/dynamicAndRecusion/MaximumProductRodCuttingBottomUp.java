package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * Given a ron of length n, find an optimal way to cut rod into smaller rods inorder to maximize product of
 * price of each of smaller rod. Assume each rod of length i has a price of i
 * <p>
 * EXAMPLES
 * Input 4
 * Output: 2*2 = 4
 * explanation
 * 1*1*1*1 = 1
 * 1*1*2 = 2
 * 1*3 = 3
 * 2*2 = 4
 * <p>
 * <p>
 * SOLUTION
 * Recursively, break down the rod into smaller pieces, keep track of max prod
 */
public class MaximumProductRodCuttingBottomUp {
    public static void main(String[] args) {
        int n = 15;

        System.out.println(getMaximumProductRodCutting(n));
    }

    private static int getMaximumProductRodCutting(int n) {

        int[] cache = new int[n + 1];

        for (int i = 0; i < n; i++)
            cache[i] = i;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                cache[i] = Math.max(cache[i], cache[i - j] * j);
            }
        }

        return cache[n];
    }
}
