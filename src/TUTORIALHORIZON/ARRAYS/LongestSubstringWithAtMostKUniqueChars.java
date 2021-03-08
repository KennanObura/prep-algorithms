package TUTORIALHORIZON.ARRAYS;

import java.util.HashMap;
import java.util.Map;

/*
Longest substring with at most K unique characters

Objective: Given a string, write an algorithm to find the longest substring with at most K characters.

Example:

Input: aabbaa cdeeeeddded, K = 3
Output: Longest substring with 3 most unique characters is: cdeeeeddded with length 11

Input: abcddefabc, K = 4
Output: Longest substring with 4 most unique characters is: abcdd with length 5

Input: aaaabbbb, K = 4
Output: Not enough unique character is present in the input string
 */
public class LongestSubstringWithAtMostKUniqueChars {
    public static void main(String[] args) {

        System.out.println(longestSubstring("abcddefabc", 4));

        System.out.println(longestSubstring("cdeeeeddded", 3));

        System.out.println(longestSubstring("aabbcf", 3));

    }


    private static int longestSubstring(String input, int K) {
        if (input.isEmpty()) return 0;
        int N = input.length();
        if (N == 1) return 1;

        /*
        - Create map to store char and positions
        - with two pointers
            let start be start pointer of win
                end be end pointer of win

        from end = 0 ... N
            put to map while map size <= k

            if size > k
                keep track of longest length
                move start pointer to start elem position +1
                remove it from map;

         */

        Map<Character, Integer> map = new HashMap<>();

        int start = 0, maxLength = 0;

        for (int end = 0; end < N; end++) {
            map.put(input.charAt(end), end);

            if (end == N - 1 || map.size() > K) {
                int currentLength = end - start;
                maxLength = Math.max(currentLength, maxLength);

                int startPosition = map.get(input.charAt(start));
                map.remove(input.charAt(start));
                start = startPosition + 1;
            }




        }
        return maxLength;
    }
}
