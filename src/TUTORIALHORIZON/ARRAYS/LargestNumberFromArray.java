package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Objective: Given an array of integers, write an algorithm to construct the largest number possible by appending the array elements.
 * <p>
 * Example:
 * <p>
 * Given Input: [7, 78]
 * Largest Number Possible: 787
 * Explanation: two possibilities are 778 and 787. 787 is larger than 778.
 * <p>
 * Given Input: [25, 42, 39]
 * Largest Number Possible: 423925
 */

public class LargestNumberFromArray {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{78, 712}));
    }



    private static int largestNumber(int[] nums) {

//        String[] items = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
//
//        Arrays.sort(items, Comparator.comparing());
//
//        System.out.println(Arrays.toString(items));
        return 2;
    }
}
