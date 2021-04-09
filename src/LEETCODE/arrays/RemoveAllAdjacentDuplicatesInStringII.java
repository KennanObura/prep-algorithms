package LEETCODE.arrays;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.
 * <p>
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }


    private static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        removeDuplicatesUtil(sb, k);

        return String.valueOf(sb);

    }


    private static void removeDuplicatesUtil(StringBuilder sb, int k) {

        int i = 0;
        int z = k;
        while (i < sb.length()) {
            int j = i + 1;

            while (z > 0 && j < sb.length() && sb.charAt(i) == sb.charAt(j)) {
                j++;
                z--;
            }



            if (j - i == k) {
                sb.delete(i, i + k);
                if (i > 0)
                    i--;
                System.out.println(sb);
            } else
                i++;

        }

    }
}
