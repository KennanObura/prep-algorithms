package CTCI.Moderate;

import java.util.Arrays;
import java.util.List;

/**
 * Sum Swap: Given two arrays of integers, find a pair of values (one value from each array) that you
 * can swap to give the two arrays the same sum.
 * EXAMPLE
 * Input: (4, 1,2, 1, 1, 2) and (3, 6, 3, 3)
 * Output: (1, 3)
 */
public class SumSwap {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sumSwap(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3})));
    }


    private static int[] sumSwap(int[] A, int[] B) {
        /*
        - Calculate sum of both arrays, sumA, sumB
        - let sumDiff be the difference of the two sums
            it means we are looking for two candidates in both A and B that sums to diff

        - Sort both arrays
        - let the bigger sum be Bigger []
            smaller sum be Smaller []

         using two pointers i, j
         start left for the smaller sum array
         start right for the bigger sum array

         if elem at i + elem at j > diff
            reduce j
         if elem i + elem at j < diff
            advance i

         if equal
            return elems at i and j
         */


        int M = B.length;
        int N = A.length;

        if (M == 0 || N == 0)
            return new int[]{-1, -1};

        int sumA = 0, sumB = 0;

        for (int i : A)
            sumA += i;
        for (int i : B)
            sumB += i;

        int sumDiff = Math.abs(sumA - sumB);

        int[] bigger = sumA > sumB ? A : B;
        int[] smaller = sumA < sumB ? A : B;

        Arrays.sort(bigger);
        Arrays.sort(smaller);


        M = smaller.length;
        int i = 0, j = bigger.length - 1;

        int[] result = new int[2];
        while (i < M && j >= 0) {
            int sum = smaller[i] + bigger[j];
            if (sum > sumDiff)
                j--;
            else if (sum < sumDiff)
                i++;

            else {
                result[0] = smaller[i];
                result[1] = bigger[j];
                break;
            }

        }
        return result;
    }
}
