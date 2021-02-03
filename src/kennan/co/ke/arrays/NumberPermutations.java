package kennan.co.ke.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPermutations {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        printPermutations(arr);
    }

    private static void printPermutations(int[] array) {
        List<List<Integer>> list = new ArrayList<>();

        getPermutations(list, new ArrayList<>(), array);

        System.out.println(list.size());
        for (List<Integer> l : list)
            System.out.println(Arrays.toString(l.toArray()));

    }

    private static void getPermutations(List<List<Integer>> list, ArrayList<Integer> inner, int[] array) {
        if (inner.size() == array.length) {
            list.add(new ArrayList<>(inner));
//            return;
        } else
            for (int i : array) {

                if (inner.contains(i)) continue;
                inner.add(i);
                getPermutations(list, inner, array);
                inner.remove(inner.size() - 1);
            }
    }


}
