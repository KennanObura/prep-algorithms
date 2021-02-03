package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 *
 * Examples:
 *
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 *
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 *
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */
public class MinimumEditDistance {
    public static void main(String[] args) {
        String X = "cut";
        String Y = "cat";


        String X1 = "sunday";
        String Y1 = "saturday";

        System.out.println(minimumDistance(X, Y));
        System.out.println(minimumDistance(X1, Y1));
    }

    private static int minimumDistance(String A, String B) {
        if (A.isEmpty() && B.isEmpty()) return 0;
        if (A.isEmpty()) return B.length();
        if (B.isEmpty()) return A.length();

        int indexA = A.length() - 1;
        int indexB = B.length() - 1;

        return minimumDistance(A, B, indexA, indexB);

    }


    private static int minimumDistance(String A, String B, int indexA, int indexB) {
        if (indexA <= 0 && indexB <= 0) return 0;

        if (indexA == 0) return indexB;
        if (indexB == 0) return indexA;

        if (A.charAt(indexA) == B.charAt(indexB))
            return minimumDistance(A, B, indexA - 1, indexB - 1);

        int removedResult = minimumDistance(A, B, indexA, indexB - 1) + 1;

        int insertedResult = minimumDistance(A, B, indexA - 1, indexB) + 1;

        int replacedResult = minimumDistance(A, B, indexA - 1, indexB - 1) + 1;

        return Math.min(removedResult, Math.min(insertedResult, replacedResult));

    }
}
