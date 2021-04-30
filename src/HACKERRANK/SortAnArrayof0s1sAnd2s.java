package HACKERRANK;

import java.util.Arrays;

/**
 * Sort an array of 0s, 1s and 2s
 * <p>
 * Difficulty Level : Medium
 * Last Updated : 09 Apr, 2021
 * <p>
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
 * Examples:
 * <p>
 * <p>
 * Input: {0, 1, 2, 0, 1, 2}
 * Output: {0, 0, 1, 1, 2, 2}
 * <p>
 * Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 * Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class SortAnArrayof0s1sAnd2s {
    public static void main(String[] args) {

        sort(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
    }

    private static void sort(int[] A) {
        int N = A.length;
        int start = 0, mid = 0, end = N - 1;


        while (mid <= end) {
            int cur = A[mid];
            if (cur == 0) {
                A[mid] = swap(A[start], A[start] = A[mid]);
                mid++;
                start++;
            } else if (cur == 1) {
                mid++;
            } else {
                A[mid] = swap(A[end], A[end] = A[mid]);
                end--;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    private static int swap(int i, int j) {
        return i;
    }
}
