package GEEKFORGEEKS.dynamicPrograming;

/**
 * Given a 3 x n board, find the number of ways to fill it with 2 x 1 dominoes.
 * <p>
 * Example 1
 * Following are all the 3 possible ways to fill up a 3 x 2 board.
 * Examples :
 * <p>
 * Input : 2
 * Output : 3
 * <p>
 * Input : 8
 * Output : 153
 * <p>
 * Input : 12
 * Output : 213
 */
public class TilingWithDominos {
    public static void main(String[] args) {
        System.out.println(tilingWays(12));
    }

    private static int DOMINO_WIDTH = 2;
    private static int DOMINO_LENGTH = 1;

    private static int tilingWays(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return tilingWays(n - DOMINO_WIDTH) +
                tilingWays(n - DOMINO_LENGTH);

    }
}
