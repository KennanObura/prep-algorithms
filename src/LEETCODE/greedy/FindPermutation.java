package LEETCODE.greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 * 484. Find Permutation
 * Medium
 * <p>
 * A permutation perm of n integers of all the integers in the range [1, n] can be represented as a string s of length n - 1 where:
 * <p>
 * s[i] == 'I' if perm[i] < perm[i + 1], and
 * s[i] == 'D' if perm[i] > perm[i + 1].
 * <p>
 * Given a string s, reconstruct the lexicographically smallest permutation perm and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal permutation that can represented by s, where the number 1 and 2 construct an increasing relationship.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can be represented as "DI", but since we want to find the smallest lexicographical permutation, you should return [2,1,3]
 */
public class FindPermutation {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findPermutation("DDIIIID")));
//
//        System.out.println(Arrays.toString(findPermutation("DDIIII")));
//
//        System.out.println(Arrays.toString(findPermutation("I")));
//
        System.out.println(Arrays.toString(findPermutation("DI")));

//        System.out.println(Arrays.toString(findPermutationReversing("DDIIIID")));
//
//        System.out.println(Arrays.toString(findPermutationReversing("DDIIII")));
//
//        System.out.println(Arrays.toString(findPermutationReversing("I")));
////
        System.out.println(Arrays.toString(findPermutationReversing("DI")));
        System.out.println(Arrays.toString(findPermutationReversing("ID")));
    }

    public static int[] findPermutation(String s) {
        int N = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N + 1];

        int k = 0;
        for (int i = 1; i <= N; i++) {
            char curr = s.charAt(i - 1);
            stack.push(i);

            if (curr == 'I') {
                while (!stack.isEmpty())
                    result[k++] = stack.pop();
            }

        }

        stack.add(N + 1);

        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
        }

        return result;
    }


    /**
     * TODO Reversing range
     */

    public static int[] findPermutationReversing(String s) {
        int N = s.length();

        int[] result = new int[N + 1];
        for (int i = 1; i <= result.length; i++)
            result[i - 1] = i;


        for (int i = 1; i < result.length; i++) {

                int k = i;
                while (i < N && s.charAt(i-1) == 'D')
                    i++;
                reverse(k-1, i-1, result);
                i++;

        }

        return result;
    }

    private static void reverse(int k, int i, int[] result) {
        while (k < i)
            result[k] = swap(result[i], result[i--] = result[k++]);

    }

    private static int swap(int i, int j) {
        return i;
    }
}
