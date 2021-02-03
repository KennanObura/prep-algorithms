package TECHIEDELIGHT.dynamicAndRecusion;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String X = "GeeksforGeeks", Y = "GeeksQuiz";
        String X1 = "zxabcdezy", Y1 = "yzabcdezx";

        String X2 = "ABC", Y2 = "BABA";

        System.out.println(longestCommonSubstring(X, Y));
        System.out.println(longestCommonSubstring(X1, Y1));
        System.out.println(longestCommonSubstring(X2, Y2));

    }

    private static int longestCommonSubstring(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) return 0;
        int indexA = A.length() - 1;
        int indexB = B.length() - 1;

        return longestCommonSubstring(A, B, indexA, indexB);
    }

    private static int longestCommonSubstring(String A, String B, int indexA, int indexB) {
        if (indexA < 0 || indexB < 0) return 0;

        if (A.charAt(indexA) == B.charAt(indexB))
            return longestCommonSubstring(A, B, indexA - 1, indexB - 1) + 1;

        int removeFromA = longestCommonSubstring(A, B, indexA - 1, indexB);

        int removeFromB = longestCommonSubstring(A, B, indexA, indexB - 1);
        return Math.max(removeFromA, removeFromB);
    }
}
