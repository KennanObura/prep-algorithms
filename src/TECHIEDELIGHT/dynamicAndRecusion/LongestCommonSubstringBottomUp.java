package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstringBottomUp {
    public static void main(String[] args) {
        String X = "GeeksforGeeks", Y = "GeeksQuiz";
        String X1 = "zxabcdezy", Y1 = "yzabcdezx";

        String X2 = "ABC", Y2 = "BABA";

        System.out.println(longestCommonSubstring(X, Y));
        System.out.println(longestCommonSubstring(X1, Y1));
        System.out.println(longestCommonSubstring(X2, Y2));

    }

    private static int longestCommonSubstring(String A, String B) {
        int[][] cache = new int[A.length() + 1][B.length() + 1];

        int max = Integer.MIN_VALUE;

        for (int row = 1; row <= A.length(); row++) {
            for (int col = 1; col <= B.length(); col++) {
                if (A.charAt(row - 1) == B.charAt(col - 1))
                    cache[row][col] = cache[row - 1][col - 1] + 1;
                max = Math.max(max, cache[row][col]);
            }
        }
        return max;
    }

}
