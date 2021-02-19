package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. Longest Repeating Character Replacement
 * Medium

 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 *
 * Note:
 * Both the string's length and k will not exceed 104.
 *
 * Example 1:
 *
 * Input:
 * s = "ABAB", k = 2
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 */

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("ABABABA", 2));
//
        System.out.println(characterReplacement("AABABBA", 1));
//
        System.out.println(characterReplacement("ABACCCB", 2));

        System.out.println(characterReplacement("AABA", 0));
    }


    private static int characterReplacement(String s, int k) {
        int N = s.length();

        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxCount = Math.max(maxCount, map.get(ch));

            if (i - start + 1 > maxCount + k) {
                char charAtStart = s.charAt(start);
                map.put(charAtStart, map.get(charAtStart) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
