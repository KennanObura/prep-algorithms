package LEETCODE.arrays;

import java.util.*;

/**
 * 1002. Find Common Characters
 * Easy
 * <p>
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * <p>
 * Example 2:
 * <p>
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));

        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));

        System.out.println(commonChars(new String[]{"cook"}));

    }

    public static List<String> commonChars(String[] A) {
        int N = A.length;
        List<String> list = new ArrayList<>();

        if (N == 1) {
            for (char C : A[0].toCharArray())
                list.add(C + "");
            return list;
        }

        Map<Character, Integer>[] dictionary = new Map[N - 1];

        String reference = A[0];

        for (int i = 1; i < N; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (char C : A[i].toCharArray())
                map.put(C, map.getOrDefault(C, 0) + 1);

            dictionary[i - 1] = map;
        }


        for (char refChar : reference.toCharArray()) {

            int k = N - 1;
            for (Map<Character, Integer> map : dictionary) {
                if (!map.containsKey(refChar))
                    break;

                if (map.get(refChar) == 0)
                    break;

                map.put(refChar, map.get(refChar) - 1);
                k--;

                if (k == 0)
                    list.add(refChar + "");


            }
        }

        return list;
    }
}
