package LEETCODE.arrays;

import java.util.Arrays;

public class SumOfMutatedArrayCloserToTarget {
    public static void main(String[] args) {

        int[] nums = {4, 9, 3};
//        System.out.println(findBestValue(nums, 10));

        System.out.println(findBestValue(new int[]{2, 3, 5}, 10));
    }

    private static int findBestValue(int[] arr, int target) {
        int N = arr.length;
        int minValue = Integer.MAX_VALUE;
        int value = -1;
        int prevSum = arr[0];


        Arrays.sort(arr);
        for (int i = 1; i < N; i++) {
            int j = N - 1;
            prevSum += arr[i];
            int mutatedSum = j * arr[i] + prevSum;
            System.out.println(mutatedSum);
            int min = Math.abs(mutatedSum - target);

            if (min < minValue) {
                minValue = min;
                value = arr[i];
            }

        }
        return value;

    }
}
