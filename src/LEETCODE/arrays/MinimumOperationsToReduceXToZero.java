package LEETCODE.arrays;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * 1658. Minimum Operations to Reduce X to Zero
 * Medium
 * You are given an integer array nums and an integer x.
 * In one operation, you can either remove the leftmost or the rightmost element from the array nums and
 * subtract its value from x. Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 * <p>
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
//
//        System.out.println(minOperations(new int[]{5, 6, 7, 8, 9}, 4));
//
//        System.out.println(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
//
        System.out.println(minOperations(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 10));

        System.out.println(minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365));


    }

    public static int minOperations(int[] nums, int x) {
        /*
        - Get arraySum
        - Get the required sumWindow (arraySum - x)

        - init startWin = 0;

        - loop with end pointer ....N
            - Keep adding currentSum while < sumWindow
            CASE
                1. currentSum > sumWindow
                remove item at start++ till current <= sumWindow
                2. currentSum == sumWindow
                calculate items off window

         */
        int N = nums.length; // {1,1,4,2,3} x =5
        int arraySum = 0;
        for (int i : nums)
            arraySum += i; // 11

        if (arraySum < x) return -1;
        if (arraySum == x) return N;


        int sumWin = arraySum - x; //6

        int start = 0, currentSum = 0, minOperation = N;

        for (int end = 0; end < N; end++) {
            currentSum += nums[end];


            while (currentSum > sumWin)
                currentSum -= nums[start++];


            if (currentSum == sumWin) {
                minOperation = Math.min(minOperation, (start + (N - 1 - end)));
            }

        }

        return minOperation == N ? -1 : minOperation;
    }


}
