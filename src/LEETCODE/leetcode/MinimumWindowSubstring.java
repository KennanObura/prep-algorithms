package LEETCODE.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "ACDOBECODEBANC", T = "ABC";

//        Output: "BANC"

        System.out.println(minWindow(S, T));
    }

    private static String minWindow(String s, String t) {
        String result = "";
        if (s.isEmpty() || t.isEmpty() || t.length() > s.length()) return result;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int start = 0, end = 0, matched = 0, windowLength = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) matched++;
            }

            while (map.size() == matched) {
                char startWinChar = s.charAt(start);


                int newLength = end - start;
                if (windowLength > newLength) {
                    windowLength = newLength;
                    result = s.substring(start, end + 1);
//                    System.out.println(result);
                }


                if (map.containsKey(startWinChar)) {
                    if (map.get(startWinChar) == 0) matched--;
                    map.put(startWinChar, map.get(startWinChar) + 1);
                }

                start++;
            }
            end++;
        }
        return result;
    }
}
