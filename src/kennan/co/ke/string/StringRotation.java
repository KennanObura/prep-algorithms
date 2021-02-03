package kennan.co.ke.string;

/**
 * : Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 * <p>
 * <p>
 * When a string is rotated, say x is a rotation of y,
 * Then y is a substring of x+x
 */
public class StringRotation {
    public static void main(String[] args) {

        System.out.println(isRotation("watebottle", "ebottlewat"));
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String temp = s1 + s1;
        return isSubstring(temp, s2);
    }

    private static boolean isSubstring(String temp, String s2) {
        for (int i = 0; i < temp.length() - s2.length(); i++) {
            if (temp.startsWith(s2, i))
                return true;
        }
        return false;
    }
}
