package kennan.co.ke.arrays;

import java.util.Arrays;

public class RotateArrayByKPositions {
    public static void main(String[] args) {

        int[] items = {1, 2, 3, 4, 5, 6, 7, 8};
        optimized(items, 2);
    }

    /*
        Loop from behind
     * shift(swap neibouring) every element 1 position at a time, K times
     *
     * o(N*K)
     */
    private static void naive(int[] array, int K) {

        for (int i = 0; i < K; i++) {
            int j = array.length - 1;
            while (j > 0) {
                array[j] = swap(array[j - 1], array[j - 1] = array[j]);
                j--;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static int swap(int i, int j) {
        return i;
    }

    /*
     *  Use temp space
     *  Space o(n)
     *  Runtime o(n)
     *
     */
    private static void better(int[] array, int K) {
        int[] temp = new int[array.length];

        int starting = K;
        for (int i = 0; i < array.length - K; i++)
            temp[starting++] = array[i];

        int j = K;
        int end = array.length - K;
        while (--j > -1 && end < array.length)
            temp[j] = array[end++];


        System.out.println(Arrays.toString(temp));
    }

    /*
     * Reverse the entire array, i.e 0 -n-1
     * Reverse subarray till K, 0 - k-1
     * Revrese the remaining subarray, ie k - n-1
     * @param array
     */
    private static void optimized(int[] array, int K) {

        reverse(array, 0, array.length - 1);
        reverse(array, 0, K-1);
        reverse(array, K , array.length-1);

        System.out.print(Arrays.toString(array));
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            array[start] = swap(array[end], array[end] = array[start]);
            start++;
            end--;
        }
    }
}
