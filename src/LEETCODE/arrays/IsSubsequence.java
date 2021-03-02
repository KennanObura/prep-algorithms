package LEETCODE.arrays;

public class IsSubsequence {
    public static void main(String[] args) {

        System.out.println(isSubsequence("abc", "ahbgdc"));

        System.out.println(isSubsequence("","abcdefgh" ));
    }

    public static boolean isSubsequence(String s, String t) {
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
