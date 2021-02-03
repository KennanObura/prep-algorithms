package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sequence, find the length of the longest palindromic subsequence in it
 */
public class LongestPalindromicSequenceTopDown {
    public static void main(String[] args) {
        String X = "ABBDCACB";
        System.out.println(longestPalindromicSequence(X));
    }


    private static int longestPalindromicSequence(String string) {
        int n = string.length();
        if (n < 2) return n;
        Map<String, Integer> lookup = new HashMap<>();

        int max = longestPalindromicSequence(string, 0, n - 1, lookup);

        for (Map.Entry entry : lookup.entrySet())
            System.out.println(entry.getKey() + " | " + entry.getValue());
        return max;
    }

    /**
     * The idea is to have 2 pointers, start and end , and compare both chars at pointers
     * <p>
     * There are two possibilities
     * chars are same
     * count  and recur to consider next chars
     * chars are not same
     * try, return max from::
     * removing from front, recur
     * removing from last, recur
     */

    private static int longestPalindromicSequence(String string, int start, int end, Map<String, Integer> lookup) {
        if (start > end) return 0;

        String key = start + "|" + end;

        if (lookup.containsKey(key))
            return lookup.get(key);

        if (start == end) return 1;


        if (string.charAt(start) == string.charAt(end)) {
            int matched = longestPalindromicSequence(string, start + 1, end - 1, lookup) + 2;
            lookup.put(key, matched);
        } else {
            int removeFirstChar = longestPalindromicSequence(string, start + 1, end, lookup);
            int removeLastChar = longestPalindromicSequence(string, start, end - 1, lookup);
            lookup.put(key, Math.max(removeFirstChar, removeLastChar));
        }
        return lookup.get(key);
    }
}
