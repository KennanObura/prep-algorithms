package TECHIEDELIGHT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {
        System.out.println(powerSet(new int[]{1, 2, 3}));
    }

    private static Set<List<Integer>> powerSet(int[] arrays) {
        Set<List<Integer>> result = new HashSet<>();
        powerSet(arrays, 0, result, new ArrayList<>());
        for (List<Integer> list : result)
            System.out.println(list);
        return result;
    }

    private static void powerSet(int[] arrays, int indx, Set<List<Integer>> result, List<Integer> internal) {
        if (indx >= arrays.length) {
//            System.out.println(internal);
            result.add(internal);
            return;
        }

        internal.add(arrays[indx]);
        powerSet(arrays, indx + 1, result, internal);
        internal.remove(internal.size() - 1);
        powerSet(arrays, indx + 1, result, internal);

    }
}
