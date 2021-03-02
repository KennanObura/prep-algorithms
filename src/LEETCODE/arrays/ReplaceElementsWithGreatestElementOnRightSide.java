package LEETCODE.arrays;
/*
1299. Replace Elements with Greatest Element on Right Side
Easy
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation:
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
Example 2:

Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
 */

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));

    }


    public static int[] replaceElements(int[] arr) {
        int N = arr.length;
        if (N == 0) return arr;
        if (N == 1) return new int[]{-1};

        int prev = arr[N - 1];
        int[] result = new int[N];
        result[N - 1] = -1;

        int i = N - 2;

        while (i >= 0) {
            result[i] = prev;
            prev = Math.max(prev, arr[i]);
            i--;
        }

        return result;

    }
}
