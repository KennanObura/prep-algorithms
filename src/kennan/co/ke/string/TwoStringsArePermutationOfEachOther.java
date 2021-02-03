package kennan.co.ke.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoStringsArePermutationOfEachOther {
    public static void main(String[] args) {
        System.out.println(permutationUsingMap("alan ", "lana"));
    }

    private static boolean permutation(String a, String b) {
        if (a.length() != b.length()) return false;
        return sortString(a).equals(sortString(b));
    }

    private static String sortString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
//        new String(chars); //another way of converting chararrays to string
        return String.valueOf(chars);

    }


    private static boolean permutationUsingMap(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : a.toCharArray())
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);

        for (char c : b.toCharArray())
            if (map.containsKey(c)) map.put(c, map.get(c) - 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet())
            if (entry.getValue() != 0) return false;

        return true;
    }


}
