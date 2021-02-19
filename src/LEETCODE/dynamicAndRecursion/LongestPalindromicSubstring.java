package LEETCODE.dynamicAndRecursion;

import kennan.co.ke.core.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("acaft"));
    }

    public static String longestPalindrome(String s) {

        int maxLength = Integer.MIN_VALUE;
        String longestString = "";
        for (int i = 0; i < s.length(); i++) {

            int[] odd = getDistanceAroundCenter(s, i, i);
            int[] even = getDistanceAroundCenter(s, i, i + 1);

            String distanceOdd = s.substring(odd[0], odd[1]);
            String distanceEven = s.substring(even[0], even[1]);

            int max = Math.max(odd[1] - odd[0], even[1] - even[0]);

            if (max > maxLength) {
                maxLength = max;
                longestString = distanceOdd.length() > distanceEven.length() ? distanceOdd : distanceEven;
            }
        }
        return longestString;
    }

    private static int[] getDistanceAroundCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        start++;

        return new int[]{start, end};
    }


}
