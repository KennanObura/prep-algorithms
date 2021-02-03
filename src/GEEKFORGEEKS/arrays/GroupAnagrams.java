package GEEKFORGEEKS.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] words = {"act", "god", "cat", "dog", "tac"};
        System.out.println(Anagrams(words));

    }

    public static List<List<String>> Anagrams(String[] string_list) {

        // Your Code here
        Map<String, List<String>> map = new HashMap<>();

        for (String S : string_list) {
            String sorted = sortString(S);
            List<String> itemList;

            if (map.containsKey(sorted))
                itemList = map.get(sorted);
            else
                itemList = new ArrayList<>();

            itemList.add(S);
            map.put(sorted, itemList);

        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet())
            result.add(entry.getValue());

        return result;

    }

    private static String sortString(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
