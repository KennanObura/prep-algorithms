package LEETCODE.arrays;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 1, 1, 1}, 1));
        System.out.println(subarraySum(new int[]{1}, 1));
        System.out.println(subarraySum(new int[]{1}, 8));
        System.out.println(subarraySum(new int[]{}, 8));
        System.out.println(subarraySum(new int[]{1}, 0));
        System.out.println(subarraySum(new int[]{8}, 8));

        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }

    public static int subarraySum(int[] nums, int k) {

        int N = nums.length;
        if (N == 1 && k != nums[0]) return 0;
        int start = 0, count = 0, maxSum = 0, minSum = 0;


        for (int end = 0; end < N; end++) {
            int temp = maxSum;
            maxSum = Math.max(nums[end], Math.max(nums[end] + maxSum, nums[end] + minSum));
            minSum = Math.min(nums[end], Math.min(nums[end] + temp, nums[end] + minSum));

            while (start < N && maxSum > k) {
                maxSum -= nums[start];
                minSum -= nums[start++];
            }


            if (maxSum == k || minSum == k) count++;

        }
        return count;
    }
}
