package LEETCODE;

import java.util.Arrays;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 * <p>
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 * <p>
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 */

public class MinDeletionToMakeCharFrequenciesUnique {
    public static void main(String[] args) {

        System.out.println(minDeletions("bbcebab"));
    }


    public static int minDeletions(String s) {
        int[] freq = new int[26];

        for (char i : s.toCharArray())
            freq[i - 'a']++;

        Arrays.sort(freq);

        int prev = freq[freq.length - 1];
        int minDel = 0;


        for (int i = freq.length - 2; i >= 0; i--) {
            if (freq[i] == 0) continue;
            if (freq[i] >= prev) {
                int temp = freq[i];
                freq[i] = Math.max(prev - 1, 0);
                minDel += temp - freq[i];
            }
            prev = freq[i];

        }

        return minDel;

    }
}
