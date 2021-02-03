package LEETCODE.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class CheckPermutationInString {
    public static void main(String[] args) {
        String s1 = "cdoo", s2 = "beiacodboooa";
        System.out.println(checkInclusion(s1, s2));
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);


        int match = 0, start = 0, end = 0;
        int windowLength = s1.length();

        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) match++;
            }

            if (match == map.size()) return true;

            if (end + 1 >= windowLength) {
                char startWindowChar = s2.charAt(start);
                if (map.containsKey(startWindowChar)) {
                    if (map.get(startWindowChar) == 0) match--;
                    map.put(startWindowChar, map.get(startWindowChar) + 1);
                }
                start++;
            }
            end++;
        }
        return false;
    }
}
