package LEETCODE.arrays;

/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 * <p>
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * If target is found in the array return its index, otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(search(nums, 1));

    }

    private static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = getMidIndex(start, end);

            if (nums[mid] == target)
                return mid;

            if (nums[start] == nums[end] && nums[end] == nums[mid]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] <= nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;


    }

    private static int getMidIndex(int start, int end) {
        return start + (end - start) / 2;
    }

}
