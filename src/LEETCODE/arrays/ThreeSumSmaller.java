package LEETCODE.arrays;

/**
 * 259. 3Sum Smaller
 * Medium
 * <p>
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * Follow up: Could you solve it in O(n2) runtime?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [], target = 0
 * Output: 0
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [0], target = 0
 * Output: 0
 */
public class ThreeSumSmaller {
    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
        System.out.println(threeSumSmaller(new int[]{}, 0));
        System.out.println(threeSumSmaller(new int[]{1, 2, 3}, 7));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int N = nums.length;
        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            int j = i + 1;
            int k = N - 1;


        }
        return count;
    }
}
