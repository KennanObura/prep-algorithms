package LEETCODE.arrays;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 */
public class TwoSumInSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    static private int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) end--;
            else if (sum < target) start++;
            else {
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
        }
        return result;
    }
}
