package java2blog.string;

import java.util.Arrays;

public class CheckIfTwoStringsAreAnagram {
    public static void main(String[] args) {

        System.out.println(isAnagram("angel", "angle"));
    }

    private static boolean isAnagram(String A, String B) {
        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();
        Arrays.sort(chA);
        Arrays.sort(chB);
        return String.valueOf(chB).equals(String.valueOf(chA));
    }
}
