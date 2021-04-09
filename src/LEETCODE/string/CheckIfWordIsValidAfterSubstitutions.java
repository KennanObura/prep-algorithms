package LEETCODE.string;

/**
 * 1003. Check If Word Is Valid After Substitutions
 * Given a string s, determine if it is valid.
 * <p>
 * A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:
 * <p>
 * Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
 * Return true if s is a valid string, otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabcbc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "aabcbc"
 * Thus, "aabcbc" is valid.
 * Example 2:
 * <p>
 * Input: s = "abcabcababcc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * Thus, "abcabcababcc" is valid.
 * Example 3:
 * <p>
 * Input: s = "abccba"
 * Output: false
 * Explanation: It is impossible to get "abccba" using the operation.
 * Example 4:
 * <p>
 * Input: s = "cababc"
 * Output: false
 * Explanation: It is impossible to get "cababc" using the operation.
 */
public class CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {

        System.out.println(isValid("abc")); //true
        System.out.println(isValid("abcabc")); //true
        System.out.println(isValid("ababcc")); //true
        System.out.println(isValid("abcc")); //false

        System.out.println(isValid("babcc")); //false
        System.out.println(isValid("abcabcababcc"));// true
        System.out.println(isValid("cababc"));// false
        System.out.println(isValid("abccba"));// false


    }

    private static boolean isValid(String s) {

        int N = s.length();
        String constant = "abc";
        while (N > 0) {
            if (s.contains(constant))
                s = s.replace(constant, "");
            else
                return false;
            N = s.length();
        }
        return true;

    }

    public static boolean isValid2(String s) {

        /*
         *
         * search for abc
         * if found
         *  remove it
         * recur to repeate
         * Base case
         * String is empty : true
         * String length is 3 < less and not abc : false
         */
        String constant = "abc";
        if (s.length() > 2)
            return operationPossible(new StringBuilder(s), constant);
        return false;

    }

    private static boolean operationPossible(StringBuilder sb, String constant) {
        int N = sb.length();

        if (N == 3 && !String.valueOf(sb).equals(constant))
            return false;

        if (N == 0) return true;

        int index = sb.indexOf(String.valueOf(constant));

        if (index < 0) return false;

        sb.delete(index, index + 3);

        return operationPossible(sb, constant);
    }
}
