package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * Given a sequence, find the length of the longest palindromic subsequence in it
 */
public class LongestPalindromicSequence {
    public static void main(String[] args) {
        String X = "ABBDCACB";
        System.out.println(longestPalindromicSequence(X));
    }


    private static int longestPalindromicSequence(String string) {
        int n = string.length();
        if (n < 2) return n;

        return longestPalindromicSequence(string, 0, n - 1);

    }

    /**
     * The idea is to have 2 pointers, start and end , and compare both chars at pointers
     * <p>
     * There are two possibilities
     * chars are same
     * count  and recur to consider next chars
     * chars are not same
     * try, return max from::
     * removing from front, recur
     * removing from last, recur
     */

    private static int longestPalindromicSequence(String string, int start, int end) {
        if (start > end) return 0;

        if(start == end) return 1;

        if (string.charAt(start) == string.charAt(end))
            return longestPalindromicSequence(string, start + 1, end - 1) + 2;

        int removeFirstChar = longestPalindromicSequence(string, start + 1, end);
        int removeLastChar = longestPalindromicSequence(string, start, end - 1);
        return Math.max(removeFirstChar, removeLastChar);
    }
}
