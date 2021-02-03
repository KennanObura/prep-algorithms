package HACKERRANK;

import java.util.HashMap;
import java.util.Map;

public class HappyLadyBugs {
    public static void main(String[] args) {
        String st1 = "AABBC";
        String st2 = "AABBC_C";
        String st3 = "_";
        String st4 = "_FWYSSENEDBO_KSEVUAB_WZ_GASASVEVS_O_NSVBYFNADE_WWVSBKAE_F_VAS_F_AAAEWBE_WEAEOAYV";
        String st5 = "AABCBC";

//        System.out.println(happyLadybugs(st1));
//        System.out.println(happyLadybugs(st2));
//        System.out.println(happyLadybugs(st3));
        System.out.println(happyLadybugs(st4));
//        System.out.println(happyLadybugs(st5));

    }

    static String happyLadybugs(String b) {


        int i = 0;
        while (i < b.length()-2 && b.charAt(i) == b.charAt(i + 1))
            i += 2;

        if (i+2 == b.length())
            return "YES";


        Map<Character, Integer> map = new HashMap<>();

        boolean emptySpace = true;

        for (char item : b.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
            if (item != '_') emptySpace = false;
        }

        if (emptySpace)
            return "YES";

        if (!map.containsKey('_') && map.size() > 1) {
            return "NO";

        } else {
            for (Map.Entry<Character, Integer> entry : map.entrySet())
                if (entry.getKey() != '_' && entry.getValue() < 2)
                    return "NO";
        }

        return "YES";
    }

}
