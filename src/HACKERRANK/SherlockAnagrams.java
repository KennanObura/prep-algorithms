package HACKERRANK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {
    public static void main(String[] args) {

        String st = "cdcd";
        String st2 = "abba";
        System.out.println(sherlockAndAnagrams(st));
        System.out.println(sherlockAndAnagrams(st2));
    }

    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sorted = sortSubString(s.substring(i, j));
                if (map.containsKey(sorted)) count++;
                map.put(sorted, map.getOrDefault(sorted, 0) + 1);
            }
        }


        for (Map.Entry entry : map.entrySet())
            System.out.println(entry.getKey() + "|" + entry.getValue());
        return count;

    }

    private static String sortSubString(String substring) {
        char[] result = substring.toCharArray();
        Arrays.sort(result);
        return String.valueOf(result);
    }
}
