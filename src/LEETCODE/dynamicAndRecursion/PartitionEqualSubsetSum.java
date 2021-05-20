package LEETCODE.dynamicAndRecursion;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 * <p>
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 1}));

        System.out.println(canPartition(new int[]{1, 2}));

        System.out.println(canPartition(new int[]{1, 2, 3}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }

    public static boolean canPartition(int[] nums) {
        double sum = 0;
        int N = nums.length;


        for (int i : nums)
            sum += i;

        sum /=2;
        Boolean [][] map = new Boolean[N][(int)sum +1];


        return canPartition(nums, N - 1, sum, map);

    }

    private static boolean canPartition(int[] nums, int i, double sum,  Boolean [][] map ) {
        if (i < 0) return false;

        if (sum == 0) return true;

        if (sum - nums[i] < 0)
            return canPartition(nums, i - 1, sum, map);


        if(map[i][(int) sum] == null) {
            boolean include = canPartition(nums, i - 1, sum - nums[i], map);
            boolean exclude = canPartition(nums, i - 1, sum, map);

            map[i][(int) sum] = include || exclude;
        }
        return  map[i][(int) sum];
    }
}
