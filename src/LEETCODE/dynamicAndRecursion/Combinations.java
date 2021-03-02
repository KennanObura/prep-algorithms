package LEETCODE.dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Medium
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Example 2:
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 */
public class Combinations {
    public static void main(String[] args) {

        System.out.println(combine(4, 2));

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        combine(n, k, 1, result, new ArrayList<>());

        System.out.println(result);

        return result;

    }

    private static void combine(int n, int k, int current, List<List<Integer>> result, List<Integer> internal) {

        if (internal.size() == k) {
            result.add(new ArrayList<>(internal));
            return;
        }

        if (internal.size() > k) return;

        for (int i = current; i <= n; i++) {
            internal.add(i);
            combine(n, k, i+1, result, internal);
            internal.remove(internal.size() - 1);
        }
    }
}
