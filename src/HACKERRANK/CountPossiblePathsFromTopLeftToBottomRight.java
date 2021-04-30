package HACKERRANK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Count all possible paths from top left to bottom right of a mXn matrix
 * <p>
 * Difficulty Level : Easy
 * Last Updated : 19 Apr, 2021
 * <p>
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down
 * Examples :
 * <p>
 * <p>
 * Input :  m = 2, n = 2;
 * Output : 2
 * There are two paths
 * (0, 0) -> (0, 1) -> (1, 1)
 * (0, 0) -> (1, 0) -> (1, 1)
 * <p>
 * Input :  m = 2, n = 3;
 * Output : 3
 * There are three paths
 * (0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
 * (0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
 * (0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 */
public class CountPossiblePathsFromTopLeftToBottomRight {
    public static void main(String[] args) {
        System.out.println(numberOfPaths(2, 3, new HashMap<>())); //3
        System.out.println(numberOfPaths(2, 2)); // 2
        System.out.println(numberOfPaths(3, 3, new HashMap<>())); // 6


        System.out.println(numberOfPathsBottomUp(2, 3));
        System.out.println(numberOfPathsBottomUp(3, 3));
    }

    /**
     * Complexity, exponential (2^n)
     * If we draw recursion tree we'll find that some problems will do recomputed over and over again
     * Can be solved with dynamic programing since it has properties of overlapping subproblems
     */
    private static int numberOfPaths(int m, int n) {
        if (n <= 0 || m <= 0) return 0;

        if (n == 1 && m == 1) return 1;
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);

    }

    private static int numberOfPaths(int m, int n, Map<String, Integer> lookup) {
        if (n <= 0 || m <= 0) return 0;

        String key = m + "|" + n;

        if (!lookup.containsKey(key)) {
            if (n == 1 && m == 1) {
                return 1;
            } else {
                int count = numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
                lookup.put(key, count);
            }
        }
        return lookup.get(key);
    }

    private static int numberOfPathsBottomUp(int m, int n) {

        int[][] lookup = new int[m][n];

        for (int i = 1; i < m; i++)
            lookup[0][i] = 1;

        for (int i = 1; i < m; i++)
            lookup[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                lookup[i][j] = lookup[i - 1][j] + lookup[i][j - 1];
            }
        }

//        for (int[] row : lookup)
//            System.out.println(Arrays.toString(row));
        return lookup[m - 1][n - 1];
    }
}
