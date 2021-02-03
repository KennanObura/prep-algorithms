package LEETCODE.numbers;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * <p>
 * APPROACH
 * <p>
 * Keep subtructing divisor from dividend till dividend is less than divisor
 */
public class Division {
    public static void main(String[] args) {

        int dividend = -2147483648;
        int divisor = -1;

        System.out.println(divide(dividend, divisor));

    }

    static int divide(int dividend, int divisor) {

        /*
         * Get sign,
         * will only be negative if and only if one of them is negative
         */
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long lDividend = Math.abs(dividend);
        long lDivisor = Math.abs(divisor);

        if(lDivisor == 1) return (int) lDividend*sign;

        int times = 0;

        while (lDividend >= lDivisor) {
            lDividend -= lDivisor;
            times++;
        }

        return times * sign;

    }
}
