package LEETCODE.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("ab"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("  "));
        System.out.println(lengthOfLongestSubstring("abba"));

    }

    private static int lengthOfLongestSubstring(String s) {
        int N = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, startIndex = 0, currentLength = 0 ;

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch) &&  startIndex <= map.get(ch))
                startIndex = map.get(ch) + 1;



            map.put(ch, i);
            currentLength = (i-startIndex)+1;
            maxLength = Math.max(maxLength, currentLength);

        }
        return maxLength;
    }
}
