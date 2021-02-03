package TECHIEDELIGHT.dynamicAndRecusion;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        System.out.println(longestCommonSubsequence(X, Y));
    }

    private static int longestCommonSubsequence(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return 0;
        int indexA = A.length() - 1;
        int indexB = B.length() - 1;

        return longestCommonSubsequence(A, B, indexA, indexB);
    }

    private static int longestCommonSubsequence(String A, String B, int indexA, int indexB) {
        if (indexA < 0 || indexB < 0) return 0;

        if (A.charAt(indexA) == B.charAt(indexB))
            return longestCommonSubsequence(A, B, indexA - 1, indexB - 1) + 1;

        int removeFromA = longestCommonSubsequence(A, B, indexA - 1, indexB);
        int removeFromB = longestCommonSubsequence(A, B, indexA, indexB - 1);
        return Math.max(removeFromA, removeFromB);
    }
}
