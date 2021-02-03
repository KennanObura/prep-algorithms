package TECHIEDELIGHT.dynamicAndRecusion;

public class MinimumSumPartition {

    public static void main(String[] args) {
        int[] nums = {10, 20, 15, 5, 25};
        System.out.println(minimumSumPartition(nums));
    }

    private static int minimumSumPartition(int[] nums) {
        int n = nums.length - 1;


        return minimumSumPartition(nums, n, 0, 0);
    }

    private static int minimumSumPartition(int[] nums, int n, int firstPart, int secondPart) {
        if (n == 0) {
            return Math.abs(firstPart - secondPart);
        }

        int includedInFirstPart = minimumSumPartition(nums, n - 1, firstPart + nums[n], secondPart);
        int includeInSecondPart = minimumSumPartition(nums, n - 1, firstPart, secondPart + nums[n]);

        return Math.min(includedInFirstPart, includeInSecondPart);

    }


}
