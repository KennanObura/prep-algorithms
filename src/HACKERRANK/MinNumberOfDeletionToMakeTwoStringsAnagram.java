package HACKERRANK;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfDeletionToMakeTwoStringsAnagram {
    public static void main(String[] args) {

        String si = "cde";
        String s2 = "abc";
        System.out.println(makingAnagrams(s2, si));
    }

    static int makingAnagrams(String s1, String s2) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int minDelete = 0;

        for (char c : s2.toCharArray())
            if (map.containsKey(c) && map.get(c) > 0)
                map.put(c, map.get(c) - 1);
            else minDelete++;

        for (Map.Entry<Character, Integer> entry : map.entrySet())
            minDelete += entry.getValue();
        return minDelete;

    }


}
