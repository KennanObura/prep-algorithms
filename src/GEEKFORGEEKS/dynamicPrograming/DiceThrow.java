package GEEKFORGEEKS.dynamicPrograming;

/**
 * Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X.
 * X is the summation of values on each face when all the dice are thrown.
 */
public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(numWays(4, 6, 15));
    }


    /**
     * Complexity => O(m^n)
     *
     * @param N
     * @param M
     * @param sum
     * @return
     */
    private static int numWays(int N, int M, int sum) {

        if(N == 0){
            return sum == 0 ? 1 : 0;
        }

        if (N < 1 || sum < 0) return 0;

        int ways = 0;

        for (int i = 1; i <= M; i++) {
            ways += numWays(N - 1, M, sum - i);
        }
        return ways;
    }
}
