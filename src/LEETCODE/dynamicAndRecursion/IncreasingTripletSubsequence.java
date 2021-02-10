package LEETCODE.dynamicAndRecursion;

/**
 * 334. Increasing Triplet Subsequence
 * <p>
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 * <p>
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 * <p>
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        int [] nums1 = {2,1,5,0,4,6};
        int [] nums2 = {5,4,3,2,1};
        int [] nums3 = {1,2,3,4,5};
        int [] nums4 = {3,4,2,1,2,5};

        System.out.println(increasingTriplet(nums1));
        System.out.println(increasingTriplet(nums2));
        System.out.println(increasingTriplet(nums3));
        System.out.println(increasingTriplet(nums4));
    }

    public static boolean increasingTriplet(int[] nums) {
        return increasingTriplet(nums, 0, -1, 3);

    }

    private static boolean increasingTriplet(int[] nums, int i, int prev, int K) {
        if (K == 0) return true;


        if (i >= nums.length) return false;


        boolean include = false;
        if (nums[i] > prev)
            include = increasingTriplet(nums, i + 1, nums[i], K - 1);
        return include || increasingTriplet(nums, i + 1, prev, K);
    }
}
