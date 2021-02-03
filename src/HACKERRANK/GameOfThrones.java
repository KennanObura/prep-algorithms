package HACKERRANK;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if it can be rearranged into a palindrome. Return the string YES or NO.
 */
public class GameOfThrones {
    public static void main(String[] args) {

        System.out.println(gameOfThrones("aba"));
    }

    static String gameOfThrones(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int oddCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) oddCount++;

            if (oddCount > 1) return "NO";

        }
        return "YES";
    }
}
