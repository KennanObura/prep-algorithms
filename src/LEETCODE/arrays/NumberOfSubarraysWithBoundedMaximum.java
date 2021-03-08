package LEETCODE.arrays;

/**
 * 795. Number of Subarrays with Bounded Maximum
 * Medium
 * <p>
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
 * <p>
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {

        System.out.println(numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

    public static int numSubarrayBoundedMax(int[] A, int L, int R) {

        /*
        let maxElem be max elem so far within the range L , R
            start = start position of the sub array
            sumSubarray =  total number of subarrays

        from i = 0 ... N
            if elem at i >= L && <= R
                track maxElem

            else if elem > R && maxElem != Integer.MIN;
                length = end - start
                sumSubarray += (length * (length+1)/ 2)
                maxElem = Integer.MIN
                start = i

         */

        int N = A.length;
        int end = 0, start = 0, maxElem = Integer.MIN_VALUE, sumSubarray = 0;

        for (; end < N; end++) {  //2, 1, 4, 3, L=2, R=3
            int elem = A[end];

            if (elem >= L && elem <= R)
                maxElem = Math.max(maxElem, elem);

            if ((end == N - 1 && maxElem != Integer.MIN_VALUE) || (elem > R && maxElem != Integer.MIN_VALUE)) {
                int count = end - start;
                sumSubarray += (count * (count + 1) / 2);
                maxElem = Integer.MIN_VALUE;
                start = end;
            }
        }
        return sumSubarray;
    }
}
