package LEETCODE.MSPRO;

import java.util.Stack;

/**
 * 402. Remove K Digits
 * Medium
 * <p>
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * <p>
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * <p>
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));

        System.out.println(removeKdigits("10200", 1));

        System.out.println(removeKdigits("10", 2));
    }

    private static String removeKdigits(String num, int k) {

        /**
         *
         * Given a sequence of D1,D2,D3,D4....Dn
         * - The left digits holds more weight on determaining whether the resulting would be min or max
         * - We remove left most digit at L  if L digit is more than L+1
         * - We can use stack to do this
         *
         *
         */

        Stack<Character> stack = new Stack<>();
        for (char dig : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > dig) {
                stack.pop();
                k--;
            }
            stack.add(dig);
        }

        /*
        K not used up
         */
        while (k > 0) {
            k--;
            stack.pop();
        }

        /*
        1 . Form the resulting  num string
        2. check if resulting has leading zero
         */
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.insert(0, stack.pop());



        int i = 0;
        while (result.length() > 1 && result.charAt(i) == '0')
            result.deleteCharAt(0);

        return result.length() > 0 ? String.valueOf(result) : 0+"";
    }


//    private static int removeKdigits(StringBuilder num, int index, int k, char curr) {
//        if (index < 0 || k == 0) {
//            return num.length() > 0 ? Integer.parseInt(String.valueOf(num)) : 0;
//        }
//        curr = num.charAt(index);
//        num.deleteCharAt(index);
//
//        int minNumber = Integer.MAX_VALUE;
//        int include = removeKdigits(num, index - 1, k - 1, curr);
//
//
//        num.insert(index, curr);
//        int notInclude = removeKdigits(num, index - 1, k, curr);
//
//        minNumber = Math.min(include, notInclude);
//        return minNumber;
//
//    }
}
