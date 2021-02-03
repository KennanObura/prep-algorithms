package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * <p>
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * <p>
 * Examples:
 * <p>
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 * <p>
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 * <p>
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */
public class MinimumEditDistanceBottomUp {
    public static void main(String[] args) {
        String X = "cut";
        String Y = "cat";


        String X1 = "sunday";
        String Y1 = "saturday";


        String X2 = "kitten";
        String Y2 = "sitting";

        String X3 = "food";
        String Y3 = "money";

        System.out.println(minimumDistance(X, Y));
        System.out.println(minimumDistance(X1, Y1));
        System.out.println(minimumDistance(X2, Y2));
        System.out.println(minimumDistance(X3, Y3));
    }

    private static int minimumDistance(String A, String B) {
        if (A.isEmpty() && B.isEmpty()) return 0;
        if (A.isEmpty()) return B.length();
        if (B.isEmpty()) return A.length();

        int indexA = A.length();
        int indexB = B.length();

        return minimumDistance(A, B, indexA, indexB);

    }


    private static int minimumDistance(String A, String B, int indexA, int indexB) {

        int[][] cache = new int[indexA + 1][indexB + 1];

        for (int row = 1; row <= indexA; row++) {
            for (int col = 1; col <= indexB; col++) {

                if (A.charAt(row - 1) == B.charAt(col - 1))
                    cache[row][col] = cache[row - 1][col - 1];
                else {
                    cache[row][col] = Math.min(cache[row - 1][col],
                            Math.min(cache[row][col - 1], cache[row - 1][col - 1])) + 1;
                }

            }
        }
        return cache[indexA][indexB];
    }
}
