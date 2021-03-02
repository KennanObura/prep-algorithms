package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Hard
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int N = s.length();
        int K = t.length();

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int start = 0;
        String result = "";
        int minLength = Integer.MAX_VALUE;
        int matched = 0;

        for (int end = 0; end < N; end++) {

            char endWinChar = s.charAt(end);

            if (map.containsKey(endWinChar)) {
                map.put(endWinChar, map.get(endWinChar) - 1);
                if (map.get(endWinChar) == 0) matched++;
            }


            while (matched == map.size()) {
                int currentLength = end - start;

                char charAtStart = s.charAt(start);

                if (currentLength < minLength) {
                    minLength = currentLength;
                    result = s.substring(start, end + 1);
                }


                if(map.containsKey(charAtStart)) {
                    if (map.get(charAtStart) == 0) matched--;
                    map.put(charAtStart, map.get(charAtStart) + 1);
                }

                start++;
            }

        }

        return result;
    }
}
