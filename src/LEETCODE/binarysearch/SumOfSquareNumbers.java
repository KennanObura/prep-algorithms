package LEETCODE.binarysearch;

/**
 * 633. Sum of Square Numbers
 * Medium
 * <p>
 * 647
 * <p>
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * <p>
 * Input: c = 3
 * Output: false
 * Example 3:
 * <p>
 * Input: c = 4
 * Output: true
 * Example 4:
 * <p>
 * Input: c = 2
 * Output: true
 * Example 5:
 * <p>
 * Input: c = 1
 * Output: true
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {

        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(9));
    }

    public static boolean judgeSquareSum(int c) {
        if (c <= 2) return true;

        for (int i = 0; i * i < c; i++) {
            long prod = (long) i * i;
            if (judgeSquareSum(prod, c-prod))
                return true;

        }
        return false;
    }

    private static boolean judgeSquareSum(long i, long c) {

        long start = 1, end = c;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long prod = (mid * mid);
            if (prod == c) return true;
            else if (prod > c) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
