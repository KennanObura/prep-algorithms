package CTCI.Moderate;

import java.util.ArrayList;

/**
 * You have an integer matrix representing a plot of land, where the value at that loca-
 * tion represents the height above sea level. A value of zero indicates water. A pond is a region of
 * water connected vertically, horizontally, or diagonally. The size of the pond is the total number of
 * connected water cells. Write a method to compute the sizes of all ponds in the matrix.
 * EXAMPLE
 * Input:
 * <p>
 * Output: 2, 4, 1 (in any order)
 * Hints: #674, #687, #706, #723
 */
public class PondSize {
    public static void main(String[] args) {

        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
        };

        System.out.println(pondSize(land));

    }

    private static ArrayList<Integer> pondSize(int[][] pond) {
        /*
        - def visited to keep track of visited slots
        - for each row, scan for see,
            if not visited
                do dfs and mark visited
                - left
                - right
                - up
                - down
                - left-up
                - left-down
                - right-up
                - right-down
         */

        int N = pond.length;
        int M = pond[0].length;

        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (pond[row][col] == 0 && !visited[row][col]) {
                    COUNT = 0;
                    countPondSize(pond, visited, row, col);
                    result.add(COUNT);
                }

            }
        }
        return result;
    }

    private static void countPondSize(int[][] pond, boolean[][] visited, int row, int col) {
        int N = pond.length;
        int M = pond[0].length;
        if (row < 0 || row >= N || col < 0 || col >= M || pond[row][col] != 0 || visited[row][col])
            return;

        COUNT++;

        visited[row][col] = true;

        countPondSize(pond, visited, row + 1, col);
        countPondSize(pond, visited, row - 1, col);
        countPondSize(pond, visited, row, col + 1);
        countPondSize(pond, visited, row, col - 1);
        countPondSize(pond, visited, row + 1, col + 1);
        countPondSize(pond, visited, row - 1, col - 1);
        countPondSize(pond, visited, row + 1, col - 1);
        countPondSize(pond, visited, row - 1, col + 1);
    }


    static Integer COUNT;
}
