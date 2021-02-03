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
public class MaximumProductRodCutting {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(getMaximumProductRodCutting(n + 1));
    }

    private static int getMaximumProductRodCutting(int n) {

        if (n < 2) return n;

        int maxPriceProduct = Integer.MIN_VALUE;

        // one by one partition the given rod of length n into
        // two parts of length (1, n-1), (2, n-2), ....
        // (n-1 , 1), (n, 0) and take maximum
        for (int i = 1; i <= n; i++) {

            int currentProduct = i * getMaximumProductRodCutting(n - i);

            maxPriceProduct = Math.max(maxPriceProduct, currentProduct);
        }
        return maxPriceProduct;
    }
}
