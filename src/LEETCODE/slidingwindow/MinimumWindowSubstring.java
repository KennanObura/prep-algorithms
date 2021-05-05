package LEETCODE.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Hard
<<<<<<< HEAD
 * <p>
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 */

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("ABC", "ABC"));
        System.out.println(minWindow("A", "A"));
        System.out.println(minWindow("ADOBECODEBANC", "PQ"));
    }

    public static String minWindow(String s, String t) {

        int N = s.length();

        Map<Character, Integer> map = new HashMap<>();


        return "";
    }

}
