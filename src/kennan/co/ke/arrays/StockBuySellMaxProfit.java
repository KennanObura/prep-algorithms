package kennan.co.ke.arrays;

public class StockBuySellMaxProfit {
    public static void main(String[] args) {
        int arr[] = { 14, 12, 70, 15, 99, 65, 21, 90 };
        System.out.println(getProfit(arr));
    }

    private static int getProfit(int[] stock) {
        int bestBuy = Integer.MAX_VALUE;
        int bestSell = Integer.MIN_VALUE;

        for (int j : stock) {
            if (j < bestBuy) {
                bestBuy = j;
                bestSell = bestBuy;
            }

            bestSell = Math.max(bestSell, j);
        }
        return bestSell - bestBuy;
    }
}
