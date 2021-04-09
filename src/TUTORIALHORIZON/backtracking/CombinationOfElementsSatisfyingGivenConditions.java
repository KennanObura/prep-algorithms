package TUTORIALHORIZON.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a positive number N, fins all combinations of 2*N elements such that every element from 1 to N
 * appears exactly twice and the distance between its two appearances is exactly equal to the value of the
 * element
 * <p>
 * Example
 * input : N = 3
 * output:
 * 3 1 2 1 3 2
 * 2 3 1 2 1 3
 */

public class CombinationOfElementsSatisfyingGivenConditions {
    public static void main(String[] args) {
        findCombinations(3);
    }

    private static class Element {
        int count;
        List<Integer> indices;

        Element(int count, List<Integer> indices) {
            count = 0;
            indices = new ArrayList<>();
        }
    }

    private static void findCombinations(int N) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Element> map = new HashMap<>();
        for (int i = 1; i <= N; i++)
            map.put(i, new Element(0, new ArrayList<>()));

        findCombinations(N, map, resultList, new ArrayList<>(), 1);
    }

    private static boolean findCombinations(int N, Map<Integer, Element> map, List<List<Integer>> result, ArrayList<Integer> internal, int value) {

        if (map.get(value).count > 0) return false;

        if (internal.size() == N * 2
                && map.get(value).count == 2
                && map.get(value).indices.get(1) - map.get(value).indices.get(0) == value + 1) {
            result.add(new ArrayList<>(internal));
            return true;
        }

        for (int i = 1; i <= N; i++) {
            internal.add(i);
            map.get(i).count++;
            map.get(i).indices.add(internal.indexOf(i));
            if (findCombinations(N, map, result, internal, i))
                return true;

        }


        return false;

    }


}
