package LEETCODE.dynamicAndRecursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 216. Combination Sum III
 * Medium
 * <p>
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * <p>
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
 * Example 4:
 * <p>
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 * Example 5:
 * <p>
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 */

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));

        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> resultSet = new HashSet<>();
        combinationSum3(1, k, n, new ArrayList<>(), resultSet);
        return new ArrayList<>(resultSet);
    }

    private static void combinationSum3(int num, int K, int N, ArrayList<Integer> list, Set<List<Integer>> resultSet) {

        if (K == 0 && N == 0) {
            resultSet.add(new ArrayList<>(list));
            return;
        }

        if (num > 9) return;

        list.add(num);
        combinationSum3(num + 1, K - 1, N - num, list, resultSet);

        list.remove(list.size() - 1);
        combinationSum3(num + 1, K, N, list, resultSet);

    }
}
