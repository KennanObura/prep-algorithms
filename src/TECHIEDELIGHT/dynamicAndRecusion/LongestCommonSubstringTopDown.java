package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstringTopDown {
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

        return longestCommonSubstring(A, B, indexA, indexB, new HashMap<>());
    }

    private static int longestCommonSubstring(String A, String B, int indexA, int indexB, Map<String, Integer> map) {
        if (indexA < 0 || indexB < 0) return 0;

        String key = indexA + "|" + indexB;
        if (map.containsKey(key)) return map.get(key);

        if (A.charAt(indexA) == B.charAt(indexB))
            return longestCommonSubstring(A, B, indexA - 1, indexB - 1, map) + 1;

        int removeFromA = longestCommonSubstring(A, B, indexA - 1, indexB, map);

        int removeFromB = longestCommonSubstring(A, B, indexA, indexB - 1, map);

        map.put(key, Math.max(removeFromA, removeFromB));
        return map.get(key);
    }
}
