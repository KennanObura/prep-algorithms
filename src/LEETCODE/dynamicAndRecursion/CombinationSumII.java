package LEETCODE.dynamicAndRecursion;

import java.util.*;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 */

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));

        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private static void combinationSum2(int[] candidates, int target, int i, ArrayList<Integer> internal, Set<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(internal));
            return;
        }

        if(i >= candidates.length || target < 0) return;

        internal.add(candidates[i]);
        combinationSum2(candidates, target - candidates[i], i + 1, internal, result);
        internal.remove(internal.size() - 1);
        combinationSum2(candidates, target, i + 1, internal, result);
    }


}
