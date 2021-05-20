package LEETCODE.dynamicAndRecursion;

import java.util.Arrays;

/**
 * 1043. Partition Array for Maximum Sum
 * Medium
 * <p>
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 * <p>
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * <p>
 * Example 3:
 * <p>
 * Input: arr = [1], k = 1
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));

        System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));

        System.out.println(maxSumAfterPartitioning(new int[]{1}, 1));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int[] map = new int[N];

        Arrays.fill(map, -1);

        int res = maxSumAfterPartitioning(arr, k, 0, map);
        System.out.println(Arrays.toString(map));

        return res;

    }

    private static int maxSumAfterPartitioning(int[] arr, int k, int index, int[] map) {
        int N = arr.length;
        if (index >= N) return 0;

        if (map[index] == -1) {

            int maxItem = arr[index];
            int maxSum = Integer.MIN_VALUE;
            int count = 0;

            for (int j = index; j < index + k; j++) {

                if (j >= N) break;

                maxItem = Math.max(maxItem, arr[j]);
                count++;

                int currentSum = (maxItem * count) + maxSumAfterPartitioning(arr, k, j + 1, map);
                maxSum = Math.max(maxSum, currentSum);
            }

            map[index] = maxSum;
        }

        return  map[index];
    }
}
