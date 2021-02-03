package LEETCODE.stack;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {

        String str = ")()())";
        String str1 = "()())";
        String str2 = "()(()";
        String str3 = "(()";

        System.out.println(longestValidParentheses(str));
        System.out.println(longestValidParentheses(str1));
        System.out.println(longestValidParentheses(str2));
        System.out.println(longestValidParentheses(str3));

    }

    public static int longestValidParentheses(String s) {
        int n = s.length();

        if (n < 2) return 0;
        char OPEN = '(';
        char CLOSE = ')';


        Stack<Character> stack = new Stack<>();
        int cache[] = new int[s.length() + 1];
        int count = 0;
        cache[0] = count;

        int maxLength = Integer.MIN_VALUE;

        for (int i = 1; i < cache.length; i++) {
            char character = s.charAt(i - 1);
            if (character == OPEN) {
                stack.push(character);

            } else if (character == CLOSE && !stack.isEmpty()) {
                stack.pop();
                cache[i] = 2 + cache[i - 2];
            }

            maxLength = Math.max(maxLength, cache[i]);

        }

        return maxLength;
    }
}
