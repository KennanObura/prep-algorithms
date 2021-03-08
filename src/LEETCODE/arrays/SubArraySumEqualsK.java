package LEETCODE.arrays;

import java.util.Arrays;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
//        System.out.println(subarraySum(new int[]{1, 1, 1, 1}, 1));
//        System.out.println(subarraySum(new int[]{1}, 1));
//        System.out.println(subarraySum(new int[]{1}, 8));
//        System.out.println(subarraySum(new int[]{}, 8));
//        System.out.println(subarraySum(new int[]{1}, 0));
//        System.out.println(subarraySum(new int[]{8}, 8));
//
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }

    public static int subarraySum(int[] nums, int k) {

        int N = nums.length;
        if (N == 1 && k != nums[0]) return 0;
        int start = 0, count = 0, maxSum = 0, minSum = 0;

        int[] sum = new int[N + 1];

        sum[0] = 0;
        for (int i = 1; i <= N; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        System.out.println(Arrays.toString(sum));
        for (; start < N; start++) {
            for (int end = start + 1; end <= N; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }


//    public static int subarraySum(int[] nums, int k) {
//
//        int N = nums.length;
//        if (N == 1 && k != nums[0]) return 0;
//        int start = 0, count = 0, maxSum = 0, minSum = 0;
//
//
//        for (int end = 0; end < N; end++) {
//            int temp = maxSum;
//            maxSum = Math.max(nums[end], Math.max(nums[end] + maxSum, nums[end] + minSum));
//            minSum = Math.min(nums[end], Math.min(nums[end] + temp, nums[end] + minSum));
//
//            while (start < N && maxSum > k) {
//                maxSum -= nums[start];
//                minSum -= nums[start++];
//            }
//
//
//            if (maxSum == k || minSum == k) count++;
//
//        }
//        return count;
//    }
}
