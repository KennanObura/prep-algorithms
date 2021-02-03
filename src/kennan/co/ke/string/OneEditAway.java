package kennan.co.ke.string;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true ---:: Insert away
 * pales. pale -> true ---:: Remove away
 * pale. bale -> true ---:: Replace away
 * pale. bake -> false
 */
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ale"));
    }

    private static boolean isOneEditAway(String a, String b) {
        if (a.length() == b.length()) // replace away
            return isEditReplace(a, b);
        if (a.length() + 1 == b.length())
            return isEditInsertOrRemove(b, a);
        if (a.length() - 1 == b.length())
            return isEditInsertOrRemove(a, b);
        return false;
    }

    private static boolean isEditInsertOrRemove(String a, String b) {
        int i = 0;
        int j = 0;
        boolean foundOne = false;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                i++;
                if (foundOne) return false;
                foundOne = true;
            } else {
                j++;
                i++;
            }
        }

        return true;
    }

    private static boolean isEditReplace(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) count++;
        return (count == 1); // expect count of different characters to be one
    }
}
