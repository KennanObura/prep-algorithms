package LEETCODE.leetcode;

import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {
    public static void main(String[] args) {

        String s = "cbaebabacd", p = "abc";

        String s2 = "abab", p2 = "ab";


//        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagramsUsingHash(s, p));
    }

    public static List<Integer> findAnagramsUsingHash(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.isEmpty() || p.isEmpty() || s.length() < p.length()) return result;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int start = 0, end = 0, matched = 0;

        for (char x : s.toCharArray()) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) matched++;
            }

            if (matched == map.size())
                result.add(start);

            if (end + 1 >= p.length()) {
                char startingWinChar = s.charAt(start);

                if (map.containsKey(startingWinChar)) {
                    if (map.get(startingWinChar) == 0) matched--;
                    map.put(startingWinChar, map.get(startingWinChar) + 1);
                }
                start++;
            }
            end++;
        }
        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.isEmpty() || p.isEmpty() || s.length() < p.length()) return result;

        int MAX = 26;
        char[] pattern = new char[MAX];
        char[] elements = new char[MAX];

        for (char c : p.toCharArray())
            pattern[c - 'a']++;

        int patternLength = p.length();

        for (int i = 0; i < patternLength; i++)
            elements[s.charAt(i) - 'a']++;

        if (Arrays.equals(elements, pattern))
            result.add(0);

        int end = patternLength;
        while (end < s.length()) {
            int start = end - patternLength;
            elements[s.charAt(start) - 'a']--;
            elements[s.charAt(end) - 'a']++;

            if (Arrays.equals(elements, pattern))
                result.add(start + 1);
            end++;
        }


        return result;
    }

}
