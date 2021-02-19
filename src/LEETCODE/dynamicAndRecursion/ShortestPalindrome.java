package LEETCODE.dynamicAndRecursion;

/**
 * 214. Shortest Palindrome
 * Hard
 * Given a string s, you can convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * <p>
 * Input: s = "abcd"
 * Output: "dcbabcd"
 */
public class ShortestPalindrome {
    public static void main(String[] args) {

        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
        System.out.println(shortestPalindrome("b"));
        System.out.println(shortestPalindrome("abcd"));
    }

    private static String shortestPalindrome(String s) {

        int N = s.length();

        int maxLength = 0;
        String longest = "";
        int startIndex = 0;

        for (int i = 0; i < N; i++) {

            int start = i, end = i;
            String odd = "", even = "";

            while (start >= 0 && end < N && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }

            odd = s.substring(++start, end);
            int tempStart = start;


            start = i;
            end = i + 1;

            while (start >= 0 && end < N && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }

            even = s.substring(++start, end);
            int max = Math.max(even.length(), odd.length());

            if (maxLength < max) {
                maxLength = max;
                longest = even.length() > odd.length() ? even : odd;
                startIndex = even.length() > odd.length() ? start : tempStart;
            }
        }

        StringBuilder result = new StringBuilder();

        System.out.println(startIndex);
        if (startIndex != 0) {
            result.append(new StringBuilder(longest).reverse());
        } else {
            result.append(new StringBuilder(s.substring(longest.length())).reverse());
        }
        result.append(s);
        return String.valueOf(result);
    }
}
