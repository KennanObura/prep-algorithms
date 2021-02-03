package kennan.co.ke.sortingAndSearching;

import java.util.*;

/**
 * Objective: Given an array of strings, write an algorithm to group the anagrams.
 * <p>
 * Example:
 * <p>
 * Input: [rat, art, cat, act, dog, god, tar, pat]
 * Output:
 * [rat, art, tar]
 * [cat, act]
 * [pat]
 * [dog, god]
 */


/*
 * Solution
 *
 * Two anagrams must have same number of characters in each.
 * Also, two anagrams will be same when sorted. We can use this property to produce a list of anagrams
 *
 * Steps
 *  1. create map, sorted string as a key, and list as value
 *  2. Traverse array of strings, sort items and put to map,
 *      if the item already exist, append to list
 *
 *
 *
 */
public class GroupingAnagram {
    public static void main(String[] args) {
        String[] strings = {"rat", "art", "cat", "act", "dog", "god", "tar", "pat"};
        List<ArrayList<String>> anagrams = groupAnagrams(strings, new ArrayList<>());

        for (ArrayList<String> list : anagrams)
            System.out.println(Arrays.toString(list.toArray()));
    }

    private static List<ArrayList<String>> groupAnagrams(String[] strings, ArrayList<ArrayList<String>> result) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String item : strings) {
            String sorted = sortString(item);
            ArrayList<String> list;
            if (!map.containsKey(sorted))
                list = new ArrayList<>();
            else
                list = map.get(sorted);
            list.add(item);
            map.put(sorted, list);
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
            result.add(entry.getValue());
        return result;
    }

    private static String sortString(String item) {
        char[] chars = item.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


}
