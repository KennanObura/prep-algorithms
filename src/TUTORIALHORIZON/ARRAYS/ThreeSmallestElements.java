package TUTORIALHORIZON.ARRAYS;

/**
 * Objective: Given an array of integers, write an algorithm to find the three smallest elements in the array.
 * <p>
 * Example:
 * <p>
 * Int [] a = { 6, 8, 1, 9, 2, 10};
 * Output: 1, 2, 6
 * Int [] a = { 6, 8, 1, 9, 2, 1, 10, 10};
 * Output: 1, 1, 2
 * Int [] a = {6};
 */

/**
 * APPROACH 1
 * Sort items and print the first 3. o(nlogn)
 * <p>
 * APPROACH II
 * <p>
 * Given array
 * def first, second, third
 * for 0 ..n
 * assign first, if current < first
 * assign second, if current < second
 * assign thirst, if current < third
 */
public class ThreeSmallestElements {
    public static void main(String[] args) {
        int[] nums = {6, 8, 1, 9, 2, 10};

        smallestElements(nums);
    }

    private static void smallestElements(int[] nums) {
        if (nums.length < 3) return;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        for (int item : nums) {
            if (first > item) {
                third = second;
                second = first;
                first = item;
            } else if (second > item) {
                third = second;
                second = item;
            } else if (third > item)
                third = item;
        }

        System.out.print(first +" ," + second +" ," + third);
    }


}
