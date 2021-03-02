package TECHIEDELIGHT.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
https://www.techiedelight.com/find-longest-substring-given-string-containing-distinct-characters/
 */
public class LongestSubstringWithDistinctChars {

    public static void main(String[] args) {

        System.out.println(longestSubstringWithDistinctChars("findlongestsubstring"));
    }

    private static String longestSubstringWithDistinctChars(String A) {
        int N = A.length();

        Map<Character, Integer> map = new HashMap<>(); //ab
        int maxLength = 0, start = 0;
        String result = "";

        for (int i = 0; i < N; i++) {
            char ch = A.charAt(i);

            if (map.containsKey(ch) && start <= map.get(ch)) { //
                start = map.get(ch) + 1; // update position
            }


            map.put(ch, i);
            int cur = i - start;
            if (maxLength < cur) {
                maxLength = cur;
                result = A.substring(start, i+1);
            }
        }
        return result;
    }
}
