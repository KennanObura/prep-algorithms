package LEETCODE.binarysearch;

/**
 * 69. Sqrt(x)
 * Easy
 * <p>
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class SquareRoot {
    public static void main(String[] args) {

        System.out.println(mySqrt(16));
        System.out.println(mySqrt(2));
    }

    public static int mySqrt(int x) {



        long start = 1, end = x;
//        long mid = start + (end - start) / 2;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long prod = mid * mid;

            if (prod == x) return (int) mid;
            else if (prod > x)
                end = mid - 1;
            else start = mid + 1;
        }
        return (int) end;
    }
}
