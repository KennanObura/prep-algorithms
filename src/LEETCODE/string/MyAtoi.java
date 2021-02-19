package LEETCODE.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. String to Integer (atoi)
 * Medium
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class MyAtoi {
    public static void main(String[] args) {

        System.out.println(myAtoi(" 21474836460   boy"));
        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String s) {

        /*
        1. strip off white space
        2. find if first char is + / -
        3. strip off leading zeros
        4. Loop string char by char for Numeric : Check edge for Max Integer overflow
         */
        String trimed = s.trim();
        int N = trimed.length();
        if (trimed.isEmpty()) return 0;
        int index = 0;
        int sign = trimed.charAt(0) == '-' ? -1 : 1;

        index = trimed.charAt(0) == '-' || trimed.charAt(0) == '+' ? 1 : 0;

        while (index < N && trimed.charAt(index) == '0')
            index++;

        int result = 0;

        while (index < N && trimed.charAt(index) >= '0' && trimed.charAt(index) <= '9') {

            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && trimed.charAt(index) - '0' > Integer.MAX_VALUE % 10)){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }


            result = result * 10 + (trimed.charAt(index++) - '0');
        }

        return result * sign;
    }


}
