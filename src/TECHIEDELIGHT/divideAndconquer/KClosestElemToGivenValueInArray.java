package TECHIEDELIGHT.divideAndconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given a sorted integer array, find the k closest elements to x in the array where k and x are given positive integers.
 *
 * The integer x may or may not be present in the input array.
 * If x is less than or equal to the first element in the input array, return first k elements.
 * Similarly, if x is more than or equal to the last element in the input array, return the last k elements.
 * The returned elements should be in the same order as present in the input array.
 */
public class KClosestElemToGivenValueInArray {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(kClosestElems(new int[]{10, 12, 15, 17, 18, 20, 25}, 16, 4)));
        System.out.println(Arrays.toString(kClosestElems(new int[]{2, 3, 4, 5, 6, 7}, 1, 3)));
        System.out.println(Arrays.toString(kClosestElems(new int[]{2, 3, 4, 5, 6, 7}, 8, 2)));


    }

    public static int[] kClosestElems(int[] A, int X, int K) {


        int N = A.length;
        int[] result = new int[K];

        if (X <= A[0]) {
            for (int i = 0; i < K; i++)
                result[i] = A[i];
        } else if (X >= A[N - 1]) {
            int j = 0;
            for (int i = N - K; i < N; i++)
                result[j++] = A[i];

        } else {



            for (int i = 1; i < N; i++) {
                if (A[i - 1] <= X && A[i] >= X) {
                    int low = i;
                    int high = i;
                    while (K > 0) {
                        if (low >= 0) {
                            low--;
                            K--;
                        }

                        if (high < N) {
                            high++;
                            K--;
                        }
                    }

                    int m = 0;
                    for (int j = low; j < high; j++) {
                        result[m++] = A[j];
                    }
                }

            }
        }

        return result;
    }
}
