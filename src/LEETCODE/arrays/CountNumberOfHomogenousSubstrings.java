package LEETCODE.arrays;

/**
 * 1759. Count Number of Homogenous Substrings
 * <p>
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * A string is homogenous if all the characters of the string are the same.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abbcccaa"
 * Output: 13
 * Explanation: The homogenous substrings are listed as below:
 * "a"   appears 3 times.
 * "aa"  appears 1 time.
 * "b"   appears 2 times.
 * "bb"  appears 1 time.
 * "c"   appears 3 times.
 * "cc"  appears 2 times.
 * "ccc" appears 1 time.
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 * Example 2:
 * <p>
 * Input: s = "xy"
 * Output: 2
 * Explanation: The homogenous substrings are "x" and "y".
 * Example 3:
 * <p>
 * Input: s = "zzzzz"
 * Output: 15
 */
public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {

        System.out.println(countHomogenous("abbcccaa"));
        System.out.println(countHomogenous("zzzzz"));
        System.out.println(countHomogenous("zyy"));
        System.out.println(countHomogenous("xy"));
//        System.out.println(countHomogenous(" "));


    }

    private static int countHomogenousNaive(String s) {
        int N = s.length();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int j = i;
            while (j < N && s.charAt(i) == s.charAt(j++))
                count++;
        }
        return count;
    }


    private static int countHomogenous(String s) {
        /*
         * Notice that the total combinations of continous items is N *(N+1)/2;
         */
        int N = s.length();
        if (N == 0) return 0;
        if (N == 1) return 1;

        long count = 0;
        char prev = 0;
        long total = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || s.charAt(i) == prev)
                count++;


            if (i == N - 1 || s.charAt(i) != prev) {
                total += (count * (count + 1) / 2) % 1000000007;
                count = 1;
            }

            prev = s.charAt(i);
        }
        return (int) total % 1000000007;
    }

//    public int countHomogenous(String s) {
//        int answer = 0;
//
//        for (int i = 0; i < s.length();) {
//            long counter = 1;
//
//            while (i + counter < s.length() && s.charAt(i + (int) counter) == s.charAt(i)) {
//                counter++;
//            }
//
//            answer += (int) (counter * (counter + 1) / 2 % 1000000007);
//            answer %= 1000000007;
//
//            i += (int) counter;
//        }
//
//        return answer;
//    }
}
