package kennan.co.ke.arrays;

public class SlidingWindowMaxSum {
    public static void main(String[] args) {
        int[] sum = {1, -2, 4, -2, 5, 9};
        int k = 4;

        System.out.println(maxSumSubArray(sum, k));
    }

    private static int maxSumSubArray(int[] nums, int k) {
        int start = 0, end = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;

            maxSum = Math.max(maxSum, sum);

            if (end + 1 >= k)
                sum -= nums[start++];

            end++;
        }
        return maxSum;
    }
}
