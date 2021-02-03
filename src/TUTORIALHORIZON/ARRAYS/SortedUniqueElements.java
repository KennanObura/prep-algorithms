package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Objective: Given an array of integers with duplicates, write a program to print unique elements in the array in sorted order.
 * <p>
 * Example:
 * <p>
 * Given Input: [6, 1, 8, 5, 2, 10, 17, 25, 6, 5, 1, 8, 8]
 * Sorted Distinct Elements: 1 2 5 6 8 10 17 25
 * <p>
 * Given Input: [2, 2, 2, 2]
 * Sorted Distinct Elements: 2
 */

/*
 * Approach
 * Use TreeSet
 *
 */
public class SortedUniqueElements {


    public static void main(String[] args) {
        int[] nums = {6, 1, 8, 5, 2, 10, 17, 25, 6, 5, 1, 8, 8};
        System.out.println(Arrays.toString(uniqueItems(nums)));
    }

    private static Object[] uniqueItems(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for (int num : nums)
            set.add(num);
        return set.toArray();
    }
}
