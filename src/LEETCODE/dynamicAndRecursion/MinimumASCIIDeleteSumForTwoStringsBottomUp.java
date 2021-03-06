package LEETCODE.dynamicAndRecursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 712. Minimum ASCII Delete Sum for Two Strings
 * Medium
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 * <p>
 * Example 1:
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * Example 2:
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 * Note:
 * <p>
 * 0 < s1.length, s2.length <= 1000.
 * All elements of each string will have an ASCII value in [97, 122].
 */
public class MinimumASCIIDeleteSumForTwoStringsBottomUp {
    public static void main(String[] args) {

        System.out.println(minimumDeleteSum("delete", "leet"));
        System.out.println(minimumDeleteSum("sea", "eat"));

    }

    public static int minimumDeleteSum(String s1, String s2) {
        int A = s1.length();
        int B = s2.length();
        int[][] dp = new int[A + 1][B + 1];

        for (int i = 1; i <= A; i++)
            dp[i][0] = dp[i-1][0]+s1.charAt(i - 1);

        for (int i = 1; i <= B; i++)
            dp[0][i] = dp[0][i-1]+s2.charAt(i - 1);


        for (int i = 1; i <=A ; i++) {
            for (int j = 1; j <=B ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i][j-1]+s2.charAt(j-1), dp[i-1][j]+s1.charAt(i-1));
            }

        }

        return dp[A][B];
    }

}
