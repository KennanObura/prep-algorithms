package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;

/**
 * Find all possible combinations with sum K from a given number N(1 to N) with the repetition of numbers is allowed
 * Objective: Given two integers N and K, Write an algorithm to find possible combinations that add to K, from the numbers 1 to N.
 * <p>
 * Condition: An integer from 1 to N can be repeated any number of times in combination.
 * <p>
 * Example:
 * <p>
 * N = 5
 * K = 3
 * Output:
 * [1, 1, 1]
 * [1, 2]
 * [3]
 * <p>
 * N = 6
 * K = 5
 * Output:
 * [1, 1, 1, 1, 1]
 * [1, 1, 1, 2]
 * [1, 1, 3]
 * [1, 2, 2]
 * [1, 4]
 * [2, 3]
 * [5]
 */
public class PossibleCombinationWithSumK {
    public static void main(String[] args) {

        possibleCombination(5, 3);
    }

    static void possibleCombination(int N, int K) {
        possibleCombination(N, K, new ArrayList<>());
    }

    private static void possibleCombination(int N, int K, ArrayList<Integer> list) {
        if (K == 0) {
            System.out.println(list);
            return;
        }

        if (N < 1 || K < 0) return;


        for (int i = 1; i <= N; i++) {
            list.add(i);
            possibleCombination(1, K - i, list);
            list.remove(list.size() - 1);
        }

    }
}
