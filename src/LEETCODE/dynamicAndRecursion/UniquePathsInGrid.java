package LEETCODE.dynamicAndRecursion;

import java.util.HashMap;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * example
 * Input: m = 3, n = 7
 * Output: 28
 */
public class UniquePathsInGrid {
    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 4, new HashMap<String, Integer>()));
    }

    public static int uniquePaths(int m, int n, HashMap<String, Integer> lookup) {

        String key = m + "|" + n;
        if (m == 1 || n == 1) return 1;

        if (!lookup.containsKey(key)) {
            int paths = uniquePaths(m, n - 1, lookup) + uniquePaths(m - 1, n, lookup);
            lookup.put(key, paths);
        }

        return lookup.get(key);
    }
}
