package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * Given a pattern, count number of times the pattern appears in the given string as a subsequence
 */

/*
 * SOLUTION
 * The idea is to use recursion to solve this problem.
 * If we compare the last character of the string with last character of the pattern, there are two possibilities
 *
 *
 * if the last character of the string is same as the last character of the pattern,
 * we recur for the remaining substring X[0..m-1] and Y[0..n-1]. Since we want all possible combinations,
 * we also consider the case when current character of string do not form part of the solution.
 * i.e. we ignore the last character of the string and recur for the remaining substring
 * X[0..m-1]
 *
 * If last character of the string is different from the last character of the pattern,
 * then we ignore the last character of the string and recur for the remaining substring
 * X[0..m-1]
 */
public class CountTimesPatternAppearsInStringSequence {
    public static void main(String[] args) {
        System.out.println(patternInStringSequence("subsequence", "sue"));
    }

    private static int patternInStringSequence(String string, String pattern) {
        return patternInStringSequence(string, pattern, string.length() - 1, pattern.length() - 1);
    }

    private static int patternInStringSequence(String string, String pattern, int sLength, int pLength) {
        if (pLength == 0 && sLength == 0 && string.charAt(sLength) == pattern.charAt(pLength))
            return 1;

        if (sLength < 0) return 0;

        if (pLength < 0) return 1;

        if (string.charAt(sLength) != pattern.charAt(pLength))
            return patternInStringSequence(string, pattern, sLength - 1, pLength);

        return patternInStringSequence(string, pattern, sLength - 1, pLength - 1) +
                patternInStringSequence(string, pattern, sLength - 1, pLength);
    }
}
