package LEETCODE.arrays;

/**
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 * <p>
 * 1513. Number of Substrings With Only 1s
 * Medium
 * <p>
 * 280
 * <p>
 * 13
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a binary string s (a string consisting only of '0' and '1's).
 * <p>
 * Return the number of substrings with all characters 1's.
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "0110111"
 * Output: 9
 * Explanation: There are 9 substring in total with only 1's characters.
 * "1" -> 5 times.
 * "11" -> 3 times.
 * "111" -> 1 time.
 * Example 2:
 * <p>
 * Input: s = "101"
 * Output: 2
 * Explanation: Substring "1" is shown 2 times in s.
 * Example 3:
 * <p>
 * Input: s = "111111"
 * Output: 21
 * Explanation: Each substring contains only 1's characters.
 * Example 4:
 * <p>
 * Input: s = "000"
 * Output: 0
 */
public class NumberOfSubstringsWithOnlyOnes {
    public static void main(String[] args) {

        System.out.println(numSub("1"));
        System.out.println(numSub("0110111"));
        System.out.println(numSub("111111"));
        System.out.println(numSub("101"));
        System.out.println(numSub("00000"));

    }

    public static int numSub(String s) {
        if (s.isEmpty()) return 0;
        int N = s.length();

        long sum = 0;
        long count = 0;


        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);

            if(ch == '1') count++;

            if (i == N - 1 || ch == '0') {
                sum += (count * (count + 1) / 2) % 1000000007;
                count = 0;
            }

        }

        return (int) sum % 1000000007;

    }
}
