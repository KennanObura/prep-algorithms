package LEETCODE.arrays;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 153. Find Minimum in Rotated Sorted Array
 * Medium
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums, return the minimum element of this array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * Example 3:
 * <p>
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * <p>
 * <p>
 * Constraints:
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        System.out.println(findMin(new int[]{8, 9, 10, 11, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));

        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMin(int[] nums) {
        /*
        We looking for inflection point in rotated array
        - find mid
        - let elem at mid be B
            let elem at start be A

            CASE
            A > B
                look left
            A < B
                look right


         */
        int N = nums.length;
        if(N == 1) return nums[0];

        int end = N - 1;
        int start = 0, mid = 0;

        if(nums[start] < nums[end]) return nums[start]; //already sorted array
        while (start < end) {
            mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if ( nums[mid] < nums[mid - 1])
                return nums[mid];

            if (nums[mid] > nums[0])
                start = mid + 1;
            else
                end = mid - 1;

        }
        return -1;
    }
}
