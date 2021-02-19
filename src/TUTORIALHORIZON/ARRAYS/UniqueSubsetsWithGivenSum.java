package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Objective: Given an array of integers and number N, Write an algorithm to find and print all the unique subsets of array for which sum is equal to N where array elements can be repeated any number of times.
 * <p>
 * Example:
 * <p>
 * int [] arrA={2,4,3}
 * sum =6
 * Output:
 * [2, 2, 2]
 * [2, 4]
 * [3, 3]
 * <p>
 * int [] arrA={2,6,3,5}
 * Sum = 8
 * [2, 2, 2, 2]
 * [2, 3, 3]
 * [2, 6]
 * [3, 5]
 */
public class UniqueSubsetsWithGivenSum {
    public static void main(String[] args) {
        int[] arrA = {2, 6, 3, 5};
        uniqueSubsetWithSum(arrA, 8);

    }

    private static void uniqueSubsetWithSum(int[] array, int sum) {
        uniqueSubsetWithSum(array, 0, sum, new ArrayList<>());
    }

    private static void uniqueSubsetWithSum(int[] array, int index, int sum, ArrayList<Integer> list) {
        if (sum == 0) {
            System.out.println(list);
            return;
        }

        if (sum < 0) return;

        for (int i = index; i < array.length; i++) {
            list.add(array[i]);
            uniqueSubsetWithSum(array, i, sum - array[i], list);
            list.remove(list.size() - 1);
        }
    }
}
