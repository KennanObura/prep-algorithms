package LEETCODE.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. Number of Different Integers in a String
 * Easy
 * <p>
 * You are given a string word that consists of digits and lowercase English letters.
 * <p>
 * You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
 * <p>
 * Return the number of different integers after performing the replacement operations on word.
 * <p>
 * Two integers are considered different if their decimal representations without any leading zeros are different.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word = "a123bc34d8ef34"
 * Output: 3
 * Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
 * <p>
 * Example 2:
 * <p>
 * Input: word = "leet1234code234"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: word = "a1b01c001"
 * Output: 1
 * Explanation: The three integers "1", "01", and "001" all represent the same integer because
 * the leading zeros are ignored when comparing their decimal values.
 */
public class NumberOfDifferentIntegersInString {
    public static void main(String[] args) {
//        System.out.println(numDifferentIntegers("leet1234code234"));
//        System.out.println(numDifferentIntegers("a1b01c001"));
//        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("167278959591294"));
    }

    public static int numDifferentIntegers(String word) {
        int i = 0;

        Set<Integer> set = new HashSet<>();
        while (i < word.length()) {
            if (!isNumber(word.charAt(i) + ""))
                i++;

            int j = i + 1;
            int number = Integer.MIN_VALUE;
            while (j <= word.length() && isNumber(word.substring(i, j))) {
                number = Math.max(number, Integer.parseInt(word.substring(i, j)));
                j++;
            }

            if (number > Integer.MIN_VALUE)
                set.add(number);
            i = j;
        }
        System.out.println(set);
        return set.size();
    }

    private static boolean isNumber(String number) {

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
