package LEETCODE.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 */
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aabc"));
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaabbc"));
        System.out.println(reorganizeString("aaaabbc"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString(""));
    }

    private static class FrequencyPair {
        FrequencyPair(char value, int count) {
            this.value = value;
            this.count = count;
        }

        char value;
        int count;
    }

    public static String reorganizeString(String S) {
        /*
        - Test  aaabc -> abaca
                aaaabbc -> ababaca

        Use greedy algorithm, place chars of highest frequency first
        Steps
            - Create map, store frequency of chars
            - Create priorityQueue, store values with highest frequency as priority

            let prev, keep track of the popped value
            - while queue is not empty
                pop from queue, current

                add prev to queue if count > 0
                add current to result
                reduce frequency
                store as prev


         */

        Map<Character, Integer> map = new HashMap<>();
     /*
        If count of a given char is more than half of the length, It is impossible. Stop
         */
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > S.length()) return "";

        }

        System.out.println("Passed");

        PriorityQueue<FrequencyPair> queue = new PriorityQueue<>(new Comparator<FrequencyPair>() {
            @Override
            public int compare(FrequencyPair a, FrequencyPair b) {
                return b.count - a.count;
            }
        });


        for (Map.Entry<Character, Integer> entry : map.entrySet())
            queue.add(new FrequencyPair(entry.getKey(), entry.getValue()));


        StringBuilder sb = new StringBuilder();
        FrequencyPair prev = null;

        while (!queue.isEmpty()) {
            FrequencyPair current = queue.poll();

            if (prev != null && prev.count > 0)
                queue.add(prev);

            sb.append(current.value);
            current.count--;

            prev = current;
        }

        return sb.length() == S.length() ? String.valueOf(sb) : "";

    }
}
