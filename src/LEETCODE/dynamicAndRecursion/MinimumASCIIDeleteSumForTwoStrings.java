package LEETCODE.dynamicAndRecursion;

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
public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {

        System.out.println(minimumDeleteSum("delete", "leet"));
        System.out.println(minimumDeleteSum("sea", "eat"));

    }

    public static int minimumDeleteSum(String s1, String s2) {
        return minimumDeleteSum(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private static int minimumDeleteSum(String A, String B, int indA, int indB) {
        if (indA < 0 && indB < 0) return 0;

        if (indA < 0) {
            int remSum = 0;
            while (indB >= 0)
                remSum += B.charAt(indB--);
            return remSum;
        }


        if (indB < 0) {
            int remSum = 0;
            while (indA >= 0)
                remSum += A.charAt(indA--);
            return remSum;
        }

        if (A.charAt(indA) == B.charAt(indB))
            return minimumDeleteSum(A, B, indA - 1, indB - 1);

        int excludeA = minimumDeleteSum(A, B, indA - 1, indB) + A.charAt(indA);
        int excludeB = minimumDeleteSum(A, B, indA, indB - 1) + B.charAt(indB);

        return Math.min(excludeA, excludeB);
    }
}
