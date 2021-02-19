package LEETCODE.dynamicAndRecursion;

import java.util.*;

public class WordBreakBottomUp {
    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> list = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, list));

        String s1 = "applepenapple";
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("apple", "pen"));

        System.out.println(wordBreak(s1, list1));


        String s2 = "catsandog";
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        System.out.println(wordBreak(s2, list2));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if(set.contains(str) && dp[j]) {
                    dp[i] = true;
                }
            }
        }


        return dp[N];
    }
}
