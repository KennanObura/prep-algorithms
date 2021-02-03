package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * Given set of positive integer, find if it can be divided into two subsets with equal sum
 * <p>
 * Example
 * <p>
 * S = {3,1,1,2,2,1},
 * <p>
 * {1,1,1,2}, {2,3}
 */
public class PartitionProblem {
    public static void main(String[] args) {

        int[] nums = {1, 1};
        int[] nums2 = {3, 1, 1, 2, 2};
        int[] A = { 7, 3, 1, 5, 4, 8 };
        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums2));
        System.out.println(canPartition(A));
    }

    private static boolean canPartition(int[] nums) {
        int total = 0;
        for (int item : nums)
            total += item;

        if (total % 2 > 0) return false;

        return canPartition(nums, total, 0, nums.length - 1);
    }

    private static boolean canPartition(int[] nums, int total, int rightPart, int index) {

        if (index < 0) return false;


        if ((rightPart * 2) == total) {
            System.out.println(rightPart * 2 + ", " + total);
            return true;
        }

        if (rightPart * 2 > total) return false;


        boolean result = canPartition(nums, total, rightPart + nums[index], index - 1);

        if (result) return true;
        else
            return canPartition(nums, total, rightPart, index - 1);
    }
}
