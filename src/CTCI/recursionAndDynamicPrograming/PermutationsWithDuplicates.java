package CTCI.recursionAndDynamicPrograming;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation of string with possible Duplicates: Result set should not have duplicates
 * <p>
 * NAIVE
 * Generate all permutations and put to set for non duplicates
 * <p>
 * Takes o(N!) in all cases.
 * for example: String "aaaaaaaaaaaaaaa", we'd generate all N! perms just to remove all of them again
 * <p>
 * SOLUTION
 * Construct frequency hashtable,
 * remove a char fro hashtable and append to result
 */
public class PermutationsWithDuplicates {
    public static void main(String[] args) {

        permutations("1000");

    }

    private static void permutations(String A) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : A.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        permutations(A, 0, new StringBuilder(), map);

    }

    private static void permutations(String a, int index, StringBuilder stringBuilder, Map<Character, Integer> map) {
        if (index >= a.length()) {
            System.out.println(stringBuilder.toString());
            return;
        }

        for (char c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                stringBuilder.append(c);
                permutations(a, index+1, stringBuilder, map);
                map.put(c, count);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }
}
