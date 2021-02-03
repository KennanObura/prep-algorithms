package HACKERRANK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The distance between two array values is the number of indices between them. Given , find the minimum distance
 * between any pair of equal elements in the array. If no such value exists, return .
 */
public class MinimumDistances {
    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 4, 1, 7};
        int[] nums1 = {3,2,1,2,3};
        int[] nums2 = {7, 1, 1, 3, 1, 8};
        System.out.println(minimumDistances(nums1));
    }

    static int minimumDistances(int[] a) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        boolean pairSeen = false;
        for (int i = 0; i < a.length; i++) {

            if (map.containsKey(a[i]))
                pairSeen = true;

            Set<Integer> set = map.getOrDefault(a[i], new HashSet<>());
            set.add(i);
            map.put(a[i], set);
        }

        if (!pairSeen)
            return -1;

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            Set<Integer> lookUpIndexSet = map.get(a[i]);

            for (Integer indices : lookUpIndexSet)
                if (indices != i)
                    minDist = Math.min(Math.abs(indices - i), minDist);
        }

        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;

    }
}
