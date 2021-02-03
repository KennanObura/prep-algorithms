package kennan.co.ke.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringInString {
    public static void main(String[] args) {

        System.out.print(lengthOfLongestSubstring("ababcb"));
    }

    private static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        Set<Character> temp;
        int length = Integer.MIN_VALUE;
        int end = 0;

        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                temp = new HashSet<>();
                temp.add(c);
                set = temp;
            } else
                set.add(c);

            if (length < set.size()) {
                length = set.size();
                end = str.indexOf(c);
            }

        }

        System.out.print(str.substring(end - length + 1, end + 1));
        return length;
    }
}
