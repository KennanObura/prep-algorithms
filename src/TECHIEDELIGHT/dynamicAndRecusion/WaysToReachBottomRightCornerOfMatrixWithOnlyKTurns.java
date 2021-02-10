package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * https://www.techiedelight.com/reach-bottom-right-corner-matrix-exactly-k-turns/
 *
 * Given N*M matrix, count the number of ways to reach bottom right corner of matrix from top-left with exactly K turns
 * allowed and using only the directions down and left
 */
public class WaysToReachBottomRightCornerOfMatrixWithOnlyKTurns {
    public static void main(String[] args) {

        int N = 3;
        int M = 3;
        int K = 1;
        System.out.println(numberOfWays(N, M, K));
    }


    private static int numberOfWays(int N, int M, int K) {
        return numberOfWays(N, M, K, 0, 0);
    }

    private static int numberOfWays(int N, int M, int K, int row, int col) {
        if (row >= N || col >= M ) return 0;

        if (row == N - 1 && col == M - 1) return 1;

        int right = numberOfWays(N, M, K - 1, row, col + 1);
        int down = numberOfWays(N, M, K - 1, row + 1, col);

        return right + down;
    }
}
