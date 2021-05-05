package LEETCODE.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Hard
 *
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 *
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        System.out.println(minWindow("ADOBECODEBANC", "BAC"));
    }

    public static String minWindow(String s, String t) {


        int N = s.length();
        int K = t.length();



        Map<Character, Integer> map = new HashMap<>();
        for (char C : t.toCharArray())
            map.put(C, map.getOrDefault(C, 0) + 1);



        String result = "";
        int start = 0, end = 0, minLength = N;

        for (; end < N; end++) {
            char charAtEnd = s.charAt(end);
            if (map.containsKey(charAtEnd)) {
                int currentCount = map.get(charAtEnd);
                if (currentCount > 0) {
                    K--;
                    map.put(charAtEnd, currentCount - 1);

                }
            }



            if (K == 0) {

                int currentLength = (end + 1) - start;
                System.out.println(minLength + "reached " + currentLength );
                if(minLength > currentLength) {

                    minLength = currentLength;
                    result = s.substring(start, end + 1);
                }


                while (K < t.length()) {
                    char charAtStart = s.charAt(start++);
                    if (map.containsKey(charAtStart)) {
                        int currentCount = map.get(charAtStart);
                        map.put(charAtStart, currentCount + 1);
                        K++;

                    }
                }
            }
        }
        return result;
    }
}
