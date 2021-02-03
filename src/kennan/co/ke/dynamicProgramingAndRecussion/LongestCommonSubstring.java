package kennan.co.ke.dynamicProgramingAndRecussion;

/**
 * Given two strings, s1, s2, return the longest common substring in them
 * s1 = "javamustberocking"
 * s2 = "nonrocksthanjavaman"
 */

/**
 * APPROACH
 * we use dp
 * define 2d matrix of length of strings s1,s2
 * using nested loop, for i & j
 * if char of st1 == char of s2
 * we do ::
 * if any of i or j == 0
 * update position with 1;
 * otherwise update with current + matrix[i-1][j-1]
 * keep track of max
 */
public class LongestCommonSubstring {


    public static void main(String[] args) {
        String stringA = "howjavamustberocking";
        String stringB = "nonrocksthanjavaman";

        System.out.print(getLongestCommonSubstring(stringA, stringB));

    }

    private static String getLongestCommonSubstring(String stringA, String stringB) {
        int[][] dict = new int[stringA.length()][stringB.length()];

        int maxLength = 0, endIndex = 0;

        for (int i = 0; i < stringA.length(); i++) {
            for (int j = 0; j < stringB.length(); j++) {
                if (stringA.charAt(i) == stringB.charAt(j)) {
                    if (i == 0 || j == 0) dict[i][j] = 1;
                    else dict[i][j] = dict[i - 1][j - 1]+1;
                }

                if (maxLength < dict[i][j]) {
                    maxLength = dict[i][j];
                    endIndex = i;
                }
            }
        }

//        System.out.print(maxLength);
        return stringA.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}
