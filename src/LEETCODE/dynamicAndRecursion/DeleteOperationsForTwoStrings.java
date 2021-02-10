package LEETCODE.dynamicAndRecursion;

/**
 * 583. Delete Operation for Two Strings
 * Medium
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * <p>
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class DeleteOperationsForTwoStrings {
    public static void main(String[] args) {

        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("delete", "leet"));
        System.out.println(minDistanceM("delete", "leet"));

    }

    public static int minDistance(String word1, String word2) {

        int N = word1.length();
        int M = word2.length();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++)
            dp[i][0] = dp[i - 1][0]+1;

        for (int i = 1; i <= M; i++)
            dp[0][i] = dp[0][i - 1]+1;


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;

            }
        }

        return dp[N][M];
    }

    public static int minDistanceM(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
