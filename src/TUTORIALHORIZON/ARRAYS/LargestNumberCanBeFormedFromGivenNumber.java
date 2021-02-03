package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a number write an algorithm to construct the largest number possible by using the digits of given number. Given number could be a negative number as well.
 * <p>
 * Example:
 * <p>
 * Given Input: 34277765
 * Output: 77765432
 * <p>
 * Given Input: -342765
 * Output: -234567
 * <p>
 * Given Input: 0
 * Output: 0
 * <p>
 * Given Input: 2034
 * Output: 4320
 */

/*
 * APPROACH
 * Sorting:
 *      given a number
 *      1. check if negative, mark isNegative
 *      2. convert to positive(if negative)
 *      3. Convert digits to list
 *      4 if Negative
 *              sort ascending
 *              sort descending if positive
 *      5. Convert back to negative if was negative
 *
 */
public class LargestNumberCanBeFormedFromGivenNumber {
    public static void main(String[] args) {
        System.out.println(largestNumberFormed(-342765));
    }

    private static int largestNumberFormed(int number) {
        boolean isNegative = (number < 0);

        if (isNegative) number *= -1;

        ArrayList<Integer> list = new ArrayList<>();

        while (number > 0) {
            int dig = number % 10;
            list.add(dig);
            number /= 10;
        }

        if (isNegative) Collections.sort(list);
        else Collections.sort(list, Collections.reverseOrder());


        int i = list.size() - 1;
        int tens = 1;
        while (i >= 0) {
            number += list.get(i--) * tens;
            tens *= 10;
        }

        if (isNegative) number *= -1;

        return number;
    }
}
