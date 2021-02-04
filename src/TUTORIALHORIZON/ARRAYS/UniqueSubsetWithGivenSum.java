package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;

public class UniqueSubsetWithGivenSum {
    public static void main(String[] args) {
        int[] input = {2, 3, 5, 6, 8, 10};
        uniqueSubsets(input, input.length - 1, 10, new ArrayList<>());


    }

    private static void uniqueSubsets(int[] array, int index, int K, ArrayList<Integer> sumResult) {



        if (K == 0) {
            System.out.println(sumResult);
            return;
        }

        if (index < 0 || K < 0) return;
        /*
        We consider two cases for the last item
        - include to the set
        - do not include to set
         */


        sumResult.add(array[index]);
        uniqueSubsets(array, index - 1, K - array[index], sumResult);


        sumResult.remove(sumResult.size() - 1);
        uniqueSubsets(array, index - 1, K, sumResult);


    }
}

