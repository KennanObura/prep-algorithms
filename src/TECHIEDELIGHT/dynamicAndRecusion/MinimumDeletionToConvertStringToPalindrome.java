package TECHIEDELIGHT.dynamicAndRecusion;



/**
 * Given a string of size ‘n’. The task is to remove or delete the minimum number of
 * characters from the string so that the resultant string is a palindrome.
 * <p>
 * Note: The order of characters should be maintained.
 * <p>
 * Examples :
 * <p>
 * Input : aebcbda
 * Output : 2
 * Remove characters 'e' and 'd'
 * Resultant string will be 'abcba'
 * which is a palindromic string
 * <p>
 * Input : geeksforgeeks
 * Output : 8
 */
public class MinimumDeletionToConvertStringToPalindrome {
    public static void main(String[] args) {

        String string = "ACBCDBAA";
        String string2 = "ACAD";
        System.out.println(minDeletion(string));
        System.out.println(minDeletion(string2));
    }

    private static int minDeletion(String str) {
        return minDeletion(str, 0, str.length() - 1);
    }


    private static int minDeletion(String str, int first, int last) {
        if (first > last) return 0;

        if (str.charAt(first) == str.charAt(last))
            return minDeletion(str, first + 1, last - 1);


        int minDel;

        minDel = 1 + Math.min(minDeletion(str, first + 1, last), minDeletion(str, first, last - 1));

        return minDel;
    }


}
