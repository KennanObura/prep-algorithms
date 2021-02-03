package GEEKFORGEEKS.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumOfSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 10, 23};
        System.out.println(maxSum(nums, nums.length, 4));


    }

    static int maxSum(int arr[], int n, int k) {
        // code here

        if (n < k) return -1;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            maxSum = Math.max(maxSum, sum);

            if (i >= k-1)
                sum -= arr[start++];
        }
        return maxSum;
    }


}
