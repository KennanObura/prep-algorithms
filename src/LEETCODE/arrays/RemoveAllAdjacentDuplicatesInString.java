package LEETCODE.arrays;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        int N = sb.length();
        int i = 0;

        while (i < N-1) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i+2);
                N = sb.length();

                if (i > 0) i--;
            } else i++;
        }
        return String.valueOf(sb);
    }


}
