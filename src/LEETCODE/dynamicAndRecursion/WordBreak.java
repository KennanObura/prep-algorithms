package LEETCODE.dynamicAndRecursion;

import java.util.*;

public class WordBreak {
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
        Map<String, Boolean> lookup = new HashMap<>();

        return wordBreakUtil(s, set, lookup);

    }


    public static boolean wordBreakUtil(String s, Set<String> dictionary, Map<String, Boolean> lookup) {
        int N = s.length();

        if (s.isEmpty()) return true;

        if (lookup.containsKey(s))
            return true;

        for (int i = 1; i <= N; i++) {
            String subst = s.substring(0, i);

            if (dictionary.contains(subst)) {
                String remaining = s.substring(i);

                boolean result = wordBreakUtil(remaining, dictionary, lookup);
                if (result) {
                    lookup.put(s, true);
                    return true;
                }

            }
        }
        return false;
    }
}
