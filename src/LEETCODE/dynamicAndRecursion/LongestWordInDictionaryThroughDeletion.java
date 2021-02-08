package LEETCODE.dynamicAndRecursion;

import java.util.*;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * Output:
 * "a"
 */
public class LongestWordInDictionaryThroughDeletion {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");
        String s = "abpcplea";

        List<String> list1 = Arrays.asList("eks", "forgeeks", "geek", "forg");
        String s1 = "geeksforgeeks";

        System.out.println(findLongestWord(s1, list1));

    }

    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        int maxLength = 0;
        String result = "";

        for (String item : d) {
            int currentLength = longestWord(s, item, s.length() - 1, item.length() - 1, new HashMap<>());
            if (currentLength > maxLength && currentLength == item.length()) {
                maxLength = currentLength;
                result = item;
            }
        }
        return result;
    }

    private static int longestWord(String s, String item, int sIndex, int iIndex, HashMap<String, Integer> lookup) {
        if (sIndex < 0 || iIndex < 0) return 0;

        String key = sIndex + "|" + iIndex;

        if(lookup.containsKey(key))
            return lookup.get(key);

        if (s.charAt(sIndex) == item.charAt(iIndex)) {
            int result = longestWord(s, item, sIndex - 1, iIndex - 1, lookup) + 1;
            lookup.put(key, result);
            return lookup.get(key);
        }

        int B = longestWord(s, item, sIndex - 1, iIndex, lookup);
        int A = longestWord(s, item, sIndex, iIndex - 1, lookup);
        lookup.put(key, Math.max(B, A));
        return lookup.get(key);
    }
}
