package GEEKFORGEEKS.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class StringLongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";
        System.out.println(longestSubsequence(X, Y));
    }

    private static int longestSubsequence(String A, String B) {
        return longestSubsequence(A, B, A.length() - 1, B.length() - 1, new HashMap<>());
    }

    private static int longestSubsequence(String A, String B, int indexA, int indexB, Map<String, Integer> lookup) {
        if (indexA < 0 || indexB < 0) return 0;

        String key = indexA + "|" + indexB;

        if (!lookup.containsKey(key)) {
            if (A.charAt(indexA) == B.charAt(indexB)) {
                int result = longestSubsequence(A, B, indexA - 1, indexB - 1, lookup) + 1;
                lookup.put(key, result);
            } else {
                int operateOnA = longestSubsequence(A, B, indexA - 1, indexB, lookup);
                int operateOnB = longestSubsequence(A, B, indexA, indexB - 1, lookup);
                lookup.put(key, Math.max(operateOnA, operateOnB));
            }
        }

        return lookup.get(key);

    }
}
