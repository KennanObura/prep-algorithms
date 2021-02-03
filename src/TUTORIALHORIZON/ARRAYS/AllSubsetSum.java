package TUTORIALHORIZON.ARRAYS;

import java.util.HashSet;
import java.util.Set;

/**
 * Objective: Given an array of numbers, write an algorithm to print all the subsets sum individually.
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
public class AllSubsetSum {
    public static void main(String[] args) {

        int[] array = {2, 4, 6};
        solution(array);
    }

    static void solution(int[] array) {
        Set<Integer> set = new HashSet<>();
        solution(array, array.length - 1, 0, set);

        System.out.println(set);
    }

    private static void solution(int[] array, int N, int sum, Set<Integer> set) {



        if (N < 0) {
//            set.add(sum);
            System.out.println(sum);
            return;
        }

        solution(array, N - 1, sum + array[N], set);
        solution(array, N - 1, sum, set);
    }
}
