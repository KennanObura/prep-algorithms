package LEETCODE.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 * Medium
 * <p>
 * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("abcd"));
    }

    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char C : s.toCharArray())
            map.put(C, map.getOrDefault(C, 0) + 1);

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return map.get(b).compareTo(map.get(a));
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet())
            queue.add(entry.getKey());

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char C = queue.poll();
            int count = map.get(C);

            while (count > 0) {
                result.append(C);
                count--;
            }
        }

        return String.valueOf(result);

    }
}
