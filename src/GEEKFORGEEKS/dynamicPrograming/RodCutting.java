package GEEKFORGEEKS.dynamicPrograming;

public class RodCutting {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodCuttingNaive(arr, arr.length));
        System.out.println("==================");
        System.out.println(rodCuttingBottomUp(arr, arr.length));
    }




    /*
    NAIVE n^n
     */

    private static int rodCuttingNaive(int[] values, int size) {
        if (size == 0) return 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < values.length; i++) {
            if (size - i >= 0) {
                int current = rodCuttingNaive(values, size - i) + values[i - 1];
                max = Math.max(max, current);
            }
        }
        return max;
    }


    private static int rodCuttingBottomUp(int[] values, int size) {
        int[] cache = new int[size + 1];


        for (int i = 1; i <= size; i++)
            for (int j = 1; j <= i; j++)
                cache[i] = Math.max(cache[i], values[j - 1] + cache[i - j]);
//
        return cache[size];
    }
}
