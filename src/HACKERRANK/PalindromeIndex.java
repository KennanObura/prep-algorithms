package HACKERRANK;

public class PalindromeIndex {
    public static void main(String[] args) {

        System.out.println(palindromeIndex("aababa"));
    }

    static int palindromeIndex(String s) {
        if (isPalindrome(s)) return -1;
        return palindromeIndex(s, 0);
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private static int palindromeIndex(String s, int k) {
        int N = s.length();
        if (k == N) return -1;

        if (!isPalindrome(s, k))
            return palindromeIndex(s, k + 1);
        else {
            return k;
        }
    }

    static boolean isPalindrome(String s, int k) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (i == k) i++;
            else if (j == k) j--;
            else {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }
        }
        return true;
    }

}
