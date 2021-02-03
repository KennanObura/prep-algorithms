package kennan.co.ke.dynamicProgramingAndRecussion;

import java.util.Arrays;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStepStairCaseProblem {

    public static void main(String[] args) {

        int n = 4;
        System.out.println("Brute force");
        int ways = possibleWaysBruteForce(n);
        System.out.println(ways);

        System.out.println("Tabulization/ Bottom up");
        ways = possibleWaysBottomUp(n, new int[n + 1]);
        System.out.println(ways);


        System.out.println("Memoization/ Top down");
        ways = countWays(n);
        System.out.println(ways);

    }

//    private static int possibleWaysMemoized(int n, int[] cache) {
//        if (n == 0) return 1;
//
//    }

    private static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) +
                    countWays(n - 3, memo);
            return memo[n];
        }
    }

    private static int possibleWaysBottomUp(int i, int[] cache) {
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;

        int[] sets = {1, 2, 3};
        for (int j = 3; j <= i; j++)
            for (int set : sets)
                if (j >= set)
                    cache[j] += cache[j - set];

        /*
         * The initial code before adding putting ways in an array
         *       for (int j = 3; j <= i; j++)
         *              cache[j] = cache[j-1] + cache[j-2] + cache[j-3]
         */
        return cache[i];
    }

    private static int possibleWaysBruteForce(int stairs) {
        if (stairs < 0) return 0;
        if (stairs == 0) return 1;
        else
            return possibleWaysBruteForce(stairs - 1)
                    + possibleWaysBruteForce(stairs - 2)
                    + possibleWaysBruteForce(stairs - 3);

    }
}
