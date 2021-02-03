package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of numbers, write an algorithm to print all the subsets sum individually.
 * <p>
 * Example:
 * <p>
 * Given Input: [1, 2]
 * Output: 3 1 2 0
 * Explanation: subsets are [0], [1], [2], [1, 2]
 * <p>
 * Given Input: [2, 4, 6]
 * 12 6 8 2 10 4 6 0
 */
public class SumOfSubsets {
    public static void main(String[] args) {

        int[] array = {1, 2};
        subsetSum(array, 0, 0, new ArrayList<>());
    }

    private static void subsetSum(int[] array, int startIndex, int sum, ArrayList<Integer> list) {
        if (startIndex == array.length) {
//            list.add(0);
            System.out.println(list);
            return;
        }

        for (int i = 0; i < array.length; i++) {
//            sum += array[startIndex];
            list.add(array[i]);
            subsetSum(array, startIndex + 1, sum, list);
            list.remove(list.size() - 1);
        }
    }
}
