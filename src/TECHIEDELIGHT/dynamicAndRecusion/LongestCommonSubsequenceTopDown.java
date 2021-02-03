package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;

public class LongestCommonSubsequenceTopDown {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        System.out.println(longestCommonSubsequence(X, Y));
    }

    private static int longestCommonSubsequence(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return 0;
        int indexA = A.length() - 1;
        int indexB = B.length() - 1;

        int[][] lookup = new int[A.length()][B.length()];
        int max = longestCommonSubsequence(A, B, indexA, indexB, lookup);
        for (int[] col : lookup)
            System.out.println(Arrays.toString(col));
        return max;
    }

    private static int longestCommonSubsequence(String A, String B, int indexA, int indexB, int[][] lookup) {
        if (indexA < 0 || indexB < 0)
            return 0;

        if (lookup[indexA][indexB] > 0)
            return lookup[indexA][indexB];

        if (A.charAt(indexA) == B.charAt(indexB))
            return longestCommonSubsequence(A, B, indexA - 1, indexB - 1, lookup) + 1;

        int removeFromA = longestCommonSubsequence(A, B, indexA - 1, indexB, lookup);
        int removeFromB = longestCommonSubsequence(A, B, indexA, indexB - 1, lookup);

        lookup[indexA][indexB] = Math.max(removeFromA, removeFromB);


        return lookup[indexA][indexB];
    }
}
