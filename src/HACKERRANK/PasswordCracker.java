package HACKERRANK;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/password-cracker/problem
 */
public class PasswordCracker {
    public static void main(String[] args) {




        List<String> passwords = Arrays.asList("we" ,"web", "adaman", "barcod");

        String attemps = "webadaman";

        System.out.println(passwordCracker(passwords, attemps));

    }

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        // Write your code here
        StringBuilder result = new StringBuilder();

        Set<String> dictionary = new HashSet<>(passwords);

        int[] lookup = new int[loginAttempt.length() + 1];
        Arrays.fill(lookup, -1);


        if (passwordCracker(dictionary, loginAttempt, result, lookup))
            return result.toString().trim();
        else return "WRONG PASSWORD";

    }

    private static boolean passwordCracker(Set<String> dictionary, String loginAttempt, StringBuilder result, int[] lookup) {
        int N = loginAttempt.length();

        if (loginAttempt.isEmpty())
            return true;


        if (lookup[N] == -1) {
            lookup[N] = 0;
            for (int i = 1; i <= N; i++) {
                String substring = loginAttempt.substring(0, i);
                if (dictionary.contains(substring)) {
                    result.append(substring).append(" ");
                    if (passwordCracker(dictionary, loginAttempt.substring(i, N), result, lookup)) {
                        lookup[N] = 1;
                        return true;
                    }

                }
            }
        }
        return lookup[N] == 1;
    }
}
