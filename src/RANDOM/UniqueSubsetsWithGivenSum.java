package RANDOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Objective: Given an array of integers and number N, Write an algorithm to find and print all the subsets of the array for which sum is equal to N.
 * <p>
 * Example:
 * <p>
 * input [] = {6,2,7,8,2,4,1,3,7,5}
 * Sum = 8
 * Output:
 * [1, 2, 2, 3]
 * [1, 2, 5]
 * [1, 3, 4]
 * [1, 7]
 * [2, 2, 4]
 * [2, 6]
 * [3, 5]
 * [8]
 * <p>
 * input [] = {1,2,3,4,5,6};
 * Sum = 6
 * [1, 2, 3]
 * [1, 5]
 * [2, 4]
 * [6]
 */
public class UniqueSubsetsWithGivenSum {
    public static void main(String[] args) {

        System.out.println(uniqueSubsets(new int[]{6,2,7,8,2,4,1,3,7,5}, 8));

    }


    private static List<List<Integer>> resultList = new ArrayList<>();

    private static List<List<Integer>> uniqueSubsets(int[] A, int sum) {

        uniqueSubsets(A, sum, 0, new ArrayList<>());
        return resultList;

    }

    private static void uniqueSubsets(int[] A, int sum, int i, ArrayList<Integer> internal) {

        if (i >= A.length)
            return;

        if (sum == 0) {
            resultList.add(new ArrayList<>(internal));
            return;
        }

        internal.add(A[i]);

        uniqueSubsets(A, sum - A[i], i + 1, internal);

        internal.remove(internal.size() - 1);

        uniqueSubsets(A, sum, i + 1, internal);
    }


}
