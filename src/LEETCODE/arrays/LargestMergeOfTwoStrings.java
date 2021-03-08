package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1754. Largest Merge Of Two Strings
 * Medium
 * You are given two strings word1 and word2. You want to construct a string merge in the following way: while either word1 or word2 are non-empty, choose one of the following options:
 * <p>
 * If word1 is non-empty, append the first character in word1 to merge and delete it from word1.
 * For example, if word1 = "abc" and merge = "dv", then after choosing this operation, word1 = "bc" and merge = "dva".
 * If word2 is non-empty, append the first character in word2 to merge and delete it from word2.
 * For example, if word2 = "abc" and merge = "", then after choosing this operation, word2 = "bc" and merge = "a".
 * Return the lexicographically largest merge you can construct.
 * <p>
 * A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b. For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "cabaa", word2 = "bcaaa"
 * Output: "cbcabaaaaa"
 * Explanation: One way to get the lexicographically largest merge is:
 * - Take from word1: merge = "c", word1 = "abaa", word2 = "bcaaa"
 * - Take from word2: merge = "cb", word1 = "abaa", word2 = "caaa"
 * - Take from word2: merge = "cbc", word1 = "abaa", word2 = "aaa"
 * - Take from word1: merge = "cbca", word1 = "baa", word2 = "aaa"
 * - Take from word1: merge = "cbcab", word1 = "aa", word2 = "aaa"
 * - Append the remaining 5 a's from word1 and word2 at the end of merge.
 * Example 2:
 * <p>
 * Input: word1 = "abcabc", word2 = "abdcaba"
 * Output: "abdcabcabcaba"
 */
public class LargestMergeOfTwoStrings {
    public static void main(String[] args) {

        System.out.println(largestMerge("abcabc", "abdcaba"));

        System.out.println(largestMerge("cabaa", "bcaaa"));

        System.out.println(largestMerge("cabaa", ""));

        System.out.println(largestMerge("ddwdddddddddddddwwddddddwddw", "wwwwwwwwwddwwdwwwwwwwwwwwwwww"));


    }




    /*
    GREEDY SOLUTION
     */

    public static String largestMerge(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();


        /*

        - Only append the largest
        CASE
        a > b
            append a and advance index
        b > a
            append b and advance index

        b == a
            CASE
                remaining of w1 > remaining of word2
                    append a and advance
                 otherwise
                    append b and advance

        append remaining of w1 if any
        append remaining of w2 if any



         */

        int i = 0, j = 0;
        StringBuilder str = new StringBuilder();

        while (i < N && j < M) {
            char a = word1.charAt(i);
            char b = word2.charAt(j);

            if (a > b) {
                str.append(a);
                i++;
            } else if (b > a) {
                str.append(b);
                j++;
            } else {
                if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                    str.append(a);
                    i++;
                } else {
                    str.append(b);
                    j++;
                }
            }
        }

        if (i < N)
            str.append(word1.substring(i));
        if (j < M)
            str.append(word2.substring(j));

        return String.valueOf(str);
    }

    /*



    RECURSION SOLUTION
     */
    public static String largestMergeRecur(String word1, String word2) {
        return largestMerge(word1, word2, 0, 0, new HashMap<String, String>());
    }

    private static String largestMerge(String word1, String word2, int word1Index, int word2Index, Map<String, String> map) {
        int N = word1.length();
        int M = word1.length();
        if (word1Index >= N && word2Index >= M)
            return null;

        if (word1Index >= N)
            return word2.substring(word2Index);

        if (word2Index >= M)
            return word1.substring(word1Index);

        String KEY = word1Index + "|" + word2Index;

        if (!map.containsKey(KEY)) {

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();


            sb1.append(word1.charAt(word1Index));
            sb1.append(largestMerge(word1, word2, word1Index + 1, word2Index, map));


            sb2.append(word2.charAt(word2Index));
            sb2.append(largestMerge(word1, word2, word1Index, word2Index + 1, map));


            if (sb1.compareTo(sb2) > 0)
                map.put(KEY, String.valueOf(sb1));
            else
                map.put(KEY, String.valueOf(sb2));
        }
        return map.get(KEY);
    }
}
