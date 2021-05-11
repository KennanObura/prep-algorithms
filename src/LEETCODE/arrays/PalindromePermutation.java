package LEETCODE.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 266. Palindrome Permutation
 * Easy
 * <p>
 * Given a string s, return true if a permutation of the string could form a palindrome.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "code"
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: s = "aab"
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "carerac"
 * Output: true
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(canPermutePalindromeUsingSet("carerec"));
        System.out.println(canPermutePalindromeUsingSet("code"));
        System.out.println(canPermutePalindromeUsingSet("c"));
        System.out.println(canPermutePalindromeUsingSet("cc"));

    }

    public static boolean canPermutePalindrome(String s) {
        int N = s.length();
        if (N < 2) return true;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        boolean oddSeen = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (oddSeen) return false;
                oddSeen = true;
            }
        }
        return true;
    }

    public static boolean canPermutePalindromeUsingSet(String s) {
        int N = s.length();
        if (N < 2) return true;

        /*
         * Using set
         * steps
         *  - put to set,
         *  Case
         *      char exists in set, meaning its even occarance
         *      remove from set
         *  Case
         *      char doesnt exist (odd occurances)
         *      add to set
         *
         * return true if set size is less than 2
         *
         */
        Set<Character> set = new HashSet<>();

        for (char C : s.toCharArray())
            if (set.contains(C))
                set.remove(C);
            else
                set.add(C);

        return set.size() < 2;
    }
}
