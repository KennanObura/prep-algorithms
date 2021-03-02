package LEETCODE.arrays;

/*
978. Longest Turbulent Subarray
Medium

Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.


Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
Example 2:

Input: arr = [4,8,12,16]
Output: 2
 */
public class LongestTurbulentSubArray {
    public static void main(String[] args) {

        System.out.println(maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));

        System.out.println(maxTurbulenceSize(new int[]{4, 8, 12, 16}));

        System.out.println(maxTurbulenceSize(new int[]{8, 1}));

        System.out.println(maxTurbulenceSize(new int[]{37, 199, 60, 296, 257, 248, 115, 31, 273, 176}));

    }

    public static int maxTurbulenceSize(int[] arr) {
        int N = arr.length;

        int end = 1, maxLengthOdds = 0;

        /*
        For i <= k < j:
            arr[k] > arr[k + 1] when k is odd, and
            arr[k] < arr[k + 1] when k is even.
         */
        int start = arr[0] < arr[end] ? 0 : 1;
        int prev = end++;
        for (; end < N; end++) {
            if ((prev % 2 != 0 && arr[prev] <= arr[end] ||
                    prev % 2 == 0 && arr[prev] >= arr[end]))
                start = end;

            prev = end;
            maxLengthOdds = Math.max(maxLengthOdds, end - start + 1);
        }


        end = start = 0;
        /*
        Or, for i <= k < j:
        arr[k] > arr[k + 1] when k is even, and
        arr[k] < arr[k + 1] when k is odd.

         */

        prev = end++;
        for (; end < N; end++) {
            if ((prev % 2 == 0 && arr[prev] <= arr[end] ||
                    prev % 2 != 0 && arr[prev] >= arr[end]))
                start = end;

            prev = end;
            maxLengthOdds = Math.max(maxLengthOdds, end - start + 1);
        }

        return maxLengthOdds;
    }
}
