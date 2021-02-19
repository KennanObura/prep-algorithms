package LEETCODE.numbers;

/**
 * 29. Divide Two Integers
 * Medium
 * <p>
 * 1557
 * <p>
 * 6289
 * <p>
 * Add to List
 * <p>
 * Share
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Note:
 * <p>
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }

    private static int divide(int dividend, int divisor) {
        int sign = dividend < 0 || divisor < 0 ? -1 : 1;

        int times = -1;
        int n = Math.abs(dividend);
        int m = Math.abs(divisor);

        while (n > 0) {
            n -= m;
            times++;
        }

        if(times >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) times * sign;
    }
}
