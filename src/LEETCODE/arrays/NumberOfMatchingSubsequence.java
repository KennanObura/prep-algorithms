package LEETCODE.arrays;

public class NumberOfMatchingSubsequence {
    public static void main(String[] args) {

        String S = "";

        String [] words = {"a", "bb", "acd", "ace"};

        System.out.println(numMatchingSubseq(S, words));
    }

    public static int numMatchingSubseq(String S, String[] words) {
        int count = 0;

        for (String st : words)
            if (isSubsequence(st, S)) count++;

        return count;
    }


    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.isEmpty() || t.isEmpty()) return false;

        int M = s.length();
        int N = t.length();

        int i = 0;
        int j = 0;
        while (i < N) {
            if (j < M && s.charAt(j) == t.charAt(i))
                j++;
            i++;

        }

        return j == M;
    }
}
