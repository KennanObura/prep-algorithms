package kennan.co.ke.arrays;

import java.util.ArrayList;

/**
 * Given two integers N and K, Write an algorithm to find possible combinations that add to K, from the numbers 1 to N.
 * Condition: An integer from 1 to N can be repeated any number of times in combination.
 * <p>
 * Given N and K
 * 1. Start with startIndex = 1; currSum = 0; list = null
 * iteratively
 * from 1 ... N
 * add i to list
 * add i to sum
 * <p>
 * recur with startIndex = startIndex
 * <p>
 * Backtrack
 * Basecase : currSum == K
 */
public class PossibleCombinationsWithSumK {
    public static void main(String[] args) {
        int N = 6;
        int K = 5;

        getCombinations(N, K, 1, 0, new ArrayList<>());
    }

    private static void getCombinations(int N, int K, int startIndex, int currSum, ArrayList<Integer> list) {
        if (currSum == K && !list.isEmpty()) {
            System.out.println(list);
            return;
        }


        for (int i = startIndex; i <= N; i++) {
            if (currSum + i > K) break;

            list.add(i);

            getCombinations(N, K, startIndex, currSum + i, list);
            list.remove(list.size() - 1);
        }


    }


}
