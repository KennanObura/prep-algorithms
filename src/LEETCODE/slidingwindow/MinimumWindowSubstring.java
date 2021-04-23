package LEETCODE.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Hard
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

        for (char C : t.toCharArray())
            map.put(C, map.getOrDefault(C, 0) + 1);

        int end = 0, start = 0, matched = map.size(), minLength = Integer.MAX_VALUE;
        String result = "";

        for (; end < N; end++) {
            char winEndChar = s.charAt(end);
            if (map.containsKey(winEndChar)) {
                map.put(winEndChar, map.get(winEndChar) - 1);

                if (map.get(winEndChar) == 0)
                    matched--;

            }


            while (matched == 0) {
                char winStartChar = s.charAt(start);
                if (map.containsKey(winStartChar)) {
                    if (map.get(winStartChar) == 0)
                        matched++;

                    map.put(winStartChar, map.get(winStartChar) + 1);
                }

                int currentLength = end - start + 1;
                if (minLength > currentLength) {
                    minLength = currentLength;
                    result = s.substring(start, end + 1);
                }

                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : result;
    }

}
