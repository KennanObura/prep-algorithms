package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

public class LongestCommonSubsequenceBottomUp {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        System.out.println(longestCommonSubsequence(X, Y));
    }

    private static int longestCommonSubsequence(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return 0;
        int lengthA = A.length();
        int lengthB = B.length();

        int[][] lookup = new int[lengthA + 1][lengthB + 1];

        for (int row = 1; row <= lengthA; row++) {
            for (int col = 1; col <= lengthB; col++) {
                if (A.charAt(row - 1) == B.charAt(col - 1))
                    lookup[row][col] = 1 + lookup[row - 1][col - 1];
                else
                    lookup[row][col] = Math.max(lookup[row - 1][col], lookup[row][col - 1]);

            }

        }


        for (int[] col : lookup)
            System.out.println(Arrays.toString(col));
        return lookup[lengthA][lengthB];
    }

}
