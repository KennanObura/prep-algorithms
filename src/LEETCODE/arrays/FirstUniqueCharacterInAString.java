package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 387. First Unique Character in a String
 * Easy
 * <p>
 * Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode")); //2
        System.out.println(firstUniqChar("aabb")); //-1
        System.out.println(firstUniqChar("leetcode")); // 0
    }

    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];

        for (char C : s.toCharArray()) {
            int index = C - 'a';
            frequency[index]++;
        }

        for (char C : s.toCharArray()) {
            int index = C - 'a';
            if (frequency[index] == 1)
                return s.indexOf(C);
        }
        return -1;

    }
}
