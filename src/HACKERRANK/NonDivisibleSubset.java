package HACKERRANK;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436);
        System.out.println(nonDivisibleSubset(7, list));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (Integer item : s) {
            int modulo = item % k;
            lookup.put(modulo, lookup.getOrDefault(modulo, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
            int key = entry.getKey();
            int rem = k - key;

            if (key > 0)
                if (lookup.containsKey(rem) && lookup.get(rem) > 0 && lookup.get(key) > 0) {
                    lookup.put(rem, lookup.get(rem) - 1);
                    lookup.put(key, lookup.get(key) - 1);
                    count += 2;
                }
        }

        return count;
    }
}
