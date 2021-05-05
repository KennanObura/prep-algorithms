package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * Easy
 * <p>
 * In a deck of cards, each card has an integer written on it.
 * <p>
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * <p>
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * <p>
 * Example 2:
 * <p>
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * <p>
 * Example 3:
 * <p>
 * Input: deck = [1]
 * Output: false
 * Explanation: No possible partition.
 * <p>
 * Example 4:
 * <p>
 * Input: deck = [1,1]
 * Output: true
 * Explanation: Possible partition [1,1].
 * <p>
 * Example 5:
 * <p>
 * Input: deck = [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2].
 */
public class XOfKindInADeckOfCards {
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{ 1,1,2,2,2,2} ));
        System.out.println(hasGroupsSizeX(new int[]{ 1,1} ));
        System.out.println(hasGroupsSizeX(new int[]{ 1} ));
        System.out.println(hasGroupsSizeX(new int[]{ 1,1,1,2,2,2,3,3} ));
    }

    public static boolean hasGroupsSizeX(int[] deck) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : deck)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> values = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            values.add(entry.getValue());

        int N = deck.length;

        search:
        for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v : values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }
}
