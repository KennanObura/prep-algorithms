package LEETCODE.dynamicAndRecursion;

/**
 * 72. Edit Distance
 * Hard
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {
    public static void main(String[] args) {

    }


    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();

        int [][] dp = new int [N+1][M+1];

        for(int i = 1; i <= N; i++)
            dp[i][0] = dp[i-1][0] + 1;


        for(int i = 1; i <= M; i++)
            dp[0][i] = dp[0][i-1] + 1;


        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
            }


        return dp[N][M];

    }
}
