package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * Medium
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargestElement {
    public static void main(String[] args) {


        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2 ));
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 10 ));
    }

    private static int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        if (k > N) return -1;

        Arrays.sort(nums);

        return nums[N - k];


    }
}
