package CTCI.recursionAndDynamicPrograming;

/*

Power Set Power set P(S) of a set S is the set of all subsets of S.
For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.

If S has n elements in it then P(s) will have 2^n elements
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {
        int[] items = {1, 2, 3};
        powerSet(items);

    }

    private static void powerSet(int[] items) {
        powerSet(items, 0, new ArrayList<>());
    }


    private static void powerSet(int[] items, int index, ArrayList<Integer> list) {
        if (index >= items.length) {
            System.out.println(list);
            return;
        }

        list.add(items[index]);
        powerSet(items, index + 1, list);


        list.remove(list.size() - 1);
        powerSet(items, index + 1, list);

    }


}
