package TECHIEDELIGHT.dynamicAndRecusion;


import java.util.HashMap;
import java.util.Map;

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
public class MinimumDeletionToConvertStringToPalindromeDP {
    public static void main(String[] args) {

        String string = "ACBCDBAA";
        String string2 = "ACAD";
//        System.out.println(minDeletion(string));
        System.out.println(minDeletion(string2));
    }

    private static int minDeletion(String str) {
        /*
        Create a map to remember min del at @first and @last
        map concat of first and last as string
         */

        return minDeletion(str, 0, str.length() - 1, new HashMap<>());
    }


    private static int minDeletion(String str, int first, int last, Map<String, Integer> map) {
        if (first > last) return 0;

        String key = first + "-" + last;
        if (map.containsKey(key))
            return map.get(key);


        int minDel;
        if (str.charAt(first) == str.charAt(last)) {
            minDel = minDeletion(str, first + 1, last - 1, map);
        } else {
            minDel = Math.min(minDeletion(str, first + 1, last, map),
                    minDeletion(str, first, last - 1, map)) + 1;
        }
        map.put(key, minDel);

        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " - min" + entry.getValue());

        return map.get(key);

    }


}
