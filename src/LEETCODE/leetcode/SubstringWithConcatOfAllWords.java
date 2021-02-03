package LEETCODE.leetcode;

import java.util.*;

/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 * <p>
 * You can return the answer in any order.
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * <p>
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * <p>
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 */

public class SubstringWithConcatOfAllWords {
    public static void main(String[] args) {
        String s = "sbarfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};

        String s2 = "barfoothefoobarman";
        String[] words2 = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int concatStringLength = wordLength * words.length;

        if (s.length() < concatStringLength) return result;

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);


        int start = 0, end = wordLength, matched = 0;

        while (end <= s.length()) {
            String endWinString = s.substring(end - wordLength, end);
            if (map.containsKey(endWinString)) {
//                System.out.println(endWinString);
                map.put(endWinString, map.get(endWinString) - 1);
                if (map.get(endWinString) == 0) matched++;
            }

            if (map.size() == matched)
                result.add(start);

            if (end >= concatStringLength) {
                String startWinString = s.substring(start, start + wordLength);
                if (map.containsKey(startWinString)) {
                    if (map.get(startWinString) == 0) matched--;
                    map.put(startWinString, map.get(startWinString) + 1);
                }
                start++;
            }
            end++;
        }

        return result;
    }
}
