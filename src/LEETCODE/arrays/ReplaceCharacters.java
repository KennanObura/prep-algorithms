package LEETCODE.arrays;

import java.util.Stack;

/**
 * 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
 * Easy
 * <p>
 * Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
 * <p>
 * It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
 * <p>
 * Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "?zs"
 * Output: "azs"
 * Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "ubv?w"
 * Output: "ubvaw"
 * Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "j?qg??b"
 * Output: "jaqgacb"
 * <p>
 * Example 4:
 * <p>
 * Input: s = "??yw?ipkj?"
 * Output: "acywaipkja"
 */
public class ReplaceCharacters {
    public static void main(String[] args) {

    }

//    public static String modifyString(String s) {
//        int N = s.length();
//        Stack<Character> stack = new Stack<>();
//
//        Character prev = null;
//        for (int i = 0; i < N; i++) {
//            char current = s.charAt(i);
//
//            if (stack.isEmpty() && current == '?')
//                stack.add('a');
//
//            if(prev != null && prev == '?' && current == 'a')
//
//
//
//            prev = current;
//        }
//
//    }
}
