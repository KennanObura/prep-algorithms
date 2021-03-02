package LEETCODE.arrays;

/**
 * 1323. Maximum 69 Number
 * Easy
 * <p>
 * 513
 * <p>
 * Given a positive integer num consisting only of digits 6 and 9.
 * <p>
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * Example 2:
 * <p>
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 * <p>
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 */
public class Maximum69Number {
    public static void main(String[] args) {

        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
        System.out.println(maximum69Number(9696));
    }

    public static int maximum69Number(int num) {
        char[] inChars = String.valueOf(num).toCharArray();

        for (int i = 0; i < inChars.length; i++) {
            char ch = inChars[i];
            if (ch == '6') {
                inChars[i] = '9';
                break;
            }
        }

        String result = String.valueOf(inChars);
        return Integer.parseInt(result);

    }
}
