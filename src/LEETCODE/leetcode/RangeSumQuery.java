package LEETCODE.leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * <p>
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
 * [[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]]
 */


public class RangeSumQuery {


    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int[] nums2 = {7,2,7,2,0};

        NumArray numArray = new NumArray(nums2);
        System.out.println(numArray.sumRange(4, 4));
        numArray.update(4, 6);
        numArray.update(0, 2);
        numArray.update(0, 9);
        System.out.println(numArray.sumRange(4, 4));
        numArray.update(3, 8);

        System.out.println(numArray.sumRange(0, 4));
    }
}

class NumArray {
    final int[] sums;
    final int[] nums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        this.nums = nums;
        preGenerateSums(nums);
    }

    public int sumRange(int i, int j) {
        return i > 0 ? sums[j] - sums[i - 1] : sums[j];
    }

    public void update(int i, int val) {
        for (int k = i; k < nums.length; k++)
            if (k == 0) sums[k] = val;
            else if(k == i) sums[k] = val + sums[k - 1];
            else sums[k] = nums[k] + sums[k - 1];

    }

    private void preGenerateSums(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (i == 0) sums[i] = nums[i];
            else sums[i] = nums[i] + sums[i - 1];
    }
}
