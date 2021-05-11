package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 267. Palindrome Permutation II
 * Medium
 * <p>
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * <p>
 * You may return the answer in any order. If s has no palindromic permutation, return an empty list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabb"
 * Output: ["abba","baab"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abc"
 * Output: []
 */
public class PalindromePermutationII {
    public static void main(String[] args) {
        System.out.println(generatePalindromes("aabb"));
        System.out.println(generatePalindromes("abc"));
        System.out.println(generatePalindromes("aaa"));
        System.out.println(generatePalindromes(""));
        System.out.println(generatePalindromes("aabbs"));
    }

    public static List<String> generatePalindromes(String s) {

        Set<String> set = new HashSet<>();
        permutations(s.toCharArray(), 0, set);
        return new ArrayList<>(set);
    }


    public static void permutations(char[] s, int index, Set<String> set) {
        int N = s.length - 1;
        if (index == N) {
            if (isPalindrome(s))
                set.add(String.valueOf(s));
            return;
        }

        for (int i = 0; i <= N; i++) {
            s[i] = swap(s[index], s[index] = s[i]);
            permutations(s, index + 1, set);
            s[i] = swap(s[index], s[index] = s[i]);
        }

    }

    private static boolean isPalindrome(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            if (s[i] != s[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static char swap(char c, char c1) {
        return c;
    }
}
