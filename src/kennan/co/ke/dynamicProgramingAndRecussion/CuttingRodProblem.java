package kennan.co.ke.dynamicProgramingAndRecussion;

/**
 * Steve has a steel rod which has a length of N inches. He also is given a list of prices that relates to
 * each of the rod pieces smaller than size N.
 * The task is to obtain the maximum revenue resulted from cutting the rod and selling the pieces.
 * Assume that the rod is of length 10 and a price list of { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 }
 * is given. Having this said, we can have the following table showing the relation between the rod pieces
 * and the prices:
 */
public class CuttingRodProblem {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8};

        System.out.println(computeBestPrice(prices, prices.length));
    }


    private static int computeBestPrice(int[] prices, int size) {
        return computeBestPrice(prices, size, 0);
    }

    private static int computeBestPrice(int[] prices, int size, int index) {
        if (size <= 0) return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++){
//            System.out.println(prices[i] + " , indx" + index);
            int currentMax = computeBestPrice(prices, size-i-1, index) + prices[i];
            max = Math.max(currentMax, max);
//            System.out.println(max + "==========");
        }


        return max;

    }
}
