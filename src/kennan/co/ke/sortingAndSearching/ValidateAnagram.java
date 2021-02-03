package kennan.co.ke.sortingAndSearching;

import java.util.HashMap;
import java.util.Map;

public class ValidateAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);

        for (char c : t.toCharArray())
            if (map.containsKey(c)) {
                if (map.get(c) > 1)
                    map.put(c, map.get(c) - 1);
                else
                    map.remove(c);
            }

        return map.isEmpty();

    }
}
