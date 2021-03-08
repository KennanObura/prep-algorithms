package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: 1
 * Example 3:
 * <p>
 * Input: s = "bb"
 * Output: 2
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));

        System.out.println(longestPalindrome("abcccccdd"));

        System.out.println(longestPalindrome("abccccc"));

        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aa"));

        System.out.println(longestPalindrome("ab"));

    }

    public static int longestPalindrome(String s) {
        int N = s.length();
        if (N < 2) return N;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int length = 0;
        int maxOdd = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if ((freq & 1) != 1)
                length += freq;
            else
                maxOdd = Math.max(maxOdd, freq);
        }

        return length + maxOdd;

    }
}
