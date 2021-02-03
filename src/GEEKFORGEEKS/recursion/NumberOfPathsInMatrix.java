package GEEKFORGEEKS.recursion;

import java.util.HashMap;

public class NumberOfPathsInMatrix {
    public static void main(String[] args) {

        System.out.println(numberOfPaths(2, 8));

    }

    private static long numberOfPaths(int N, int M) {
//        int[][] matrix = new int[N][M];

        return numberOfPaths(N - 1, M - 1, 0, 0, new HashMap<String, Long>());
    }

    private static long numberOfPaths(int N, int M, int row, int col, HashMap<String, Long> lookup) {
        if (row < 0 || col < 0 || row > N || col > M)
            return 0;

        String key = row + "|" + col;

        if (lookup.containsKey(key))
            return lookup.get(key);

        if (row == N && col == M) {
            lookup.put(key, (long) 1);
        } else {
            long result = numberOfPaths(N, M, row + 1, col, lookup)
                    + numberOfPaths(N, M, row, col + 1, lookup);
            lookup.put(key, result);
        }

        return lookup.get(key);
    }


}
