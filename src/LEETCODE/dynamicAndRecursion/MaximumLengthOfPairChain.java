package LEETCODE.dynamicAndRecursion;

/**
 * 646. Maximum Length of Pair Chain
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int [][] pairs = {
                {1,2},
                {2,3},
                {3,4},
                {3,4},
                {5,6},
                {7,10}
        };

        System.out.println(findLongestChain(pairs));
    }

    private static int findLongestChain(int[][] pairs) {
        return findLongestChain(pairs, 0, -1);
    }

    private static int findLongestChain(int[][] pairs, int i, int prev) {
        int N = pairs.length;
        if (i >= N) return 0;

        int include = 0;
        if (pairs[i][0] > prev)
            include = findLongestChain(pairs, i + 1, pairs[i][1]) + 1;
        return Math.max(include, findLongestChain(pairs, i + 1, prev));
    }
}
