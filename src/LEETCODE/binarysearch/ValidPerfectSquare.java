package LEETCODE.binarysearch;

/**
 * 367. Valid Perfect Square
 * Easy
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Follow up: Do not use any built-in library function such as sqrt.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 16
 * Output: true
 * Example 2:
 * <p>
 * Input: num = 14
 * Output: false
 */

public class ValidPerfectSquare {
    public static void main(String[] args) {

        System.out.println(isPerfectSquare(25));
        System.out.println(isPerfectSquare(9));

    }


    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long start = 2, end = (long) num / 2;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long prod = mid * mid;

            if (prod == num) return true;
            else if (prod > num)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}
