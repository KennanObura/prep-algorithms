package TUTORIALHORIZON.ARRAYS;

/**
 *
 * Objective: Given an array of integers, write an algorithm to find the two smallest elements in the array.
 *
 * Example:
 *
 * Int [] a = {
 * 6, 8, 1, 9, 2, 10};
 * Output: 1, 2
 * Int [] a = {
 * 6, 8, 1, 9, 2, 1, 10, 10};
 * Output: 1, 1
 * Int [] a ={6};
 * Output: Invalid Input, array size is less than 2
 */
public class TwoSmallestElements {
    public static void main(String[] args) {
        int[] nums = {6, 8, 1, 9, 2, 10};

        smallestElements(nums);
    }

    private static void smallestElements(int[] nums) {
        if (nums.length < 2) return;

        int first = Integer.MAX_VALUE;
        int second = first;
        for (int i : nums) {
            first = Math.min(first, i);

            if (i > first)
                second = Math.min(second, i);
        }

        System.out.println(first);
        System.out.println(second);
    }
}
