package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 738. Monotone Increasing Digits
 * Medium
 * <p>
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * <p>
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * <p>
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {

        System.out.println(monotoneIncreasingDigits(299));

        System.out.println(monotoneIncreasingDigits(53));
        System.out.println(monotoneIncreasingDigits(10));

        System.out.println(monotoneIncreasingDigits(3328));
        System.out.println(monotoneIncreasingDigits(1234));
    }


    public static int monotoneIncreasingDigits(int N) {

        char[] number = String.valueOf(N).toCharArray();
        int M = number.length;

        if (M <= 1) return N;
        if (M == 2) {
            if (number[0] > number[1]) {
                int firstDig = Integer.parseInt(String.valueOf(number[0]));
                firstDig = (firstDig - 1) * 10;
                return firstDig + 9;
            }
        }


        int i = 0, j = 1, k = 2;

        if (number[i] > number[k]) {
            number[i] -= 1;
            while (j < M)
                number[j++] = '9';
        } else if (number[j] > number[k]) {
            number[j] -= 1;
            while (k < M)
                number[k++] = '9';
        }

        int result = 0;
        int tens = 1;
        i = M-1;

//        System.out.println(Arrays.toString(number));

        while (i >= 0) {
            int dig = Integer.parseInt(String.valueOf(number[i]));
            result += (dig * tens);
            tens *= 10;
            i--;

        }
        return result;

    }
}
