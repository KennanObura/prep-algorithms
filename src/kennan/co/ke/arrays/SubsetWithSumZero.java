package kennan.co.ke.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.spi.AbstractResourceBundleProvider;

/**
 * given array
 * <p>
 * 1. sort ina ascending order
 * 2. start with
 * index =0, currentSum =0, list null
 * <p>
 * iteratively
 * add to currSum
 * add to list
 * recur with index+1
 * <p>
 * backtrack
 * Base case : currSum = 0
 */
public class SubsetWithSumZero {
    public static void main(String[] args) {

        int[] arrA = {8, 3, 5, 1, -4, -8};

        Arrays.sort(arrA);
        subsetOfSumZero(arrA, 0, 0, new ArrayList<>());
    }

    private static void subsetOfSumZero(int[] arrA, int start, int sum, ArrayList<Integer> list) {
        if (sum == 0 && !list.isEmpty()) {
            System.out.println(list);
            return;
        }

        for (int j = start; j < arrA.length; j++) {
            if(sum + arrA[j] > 0) break;

            list.add(arrA[j]);
            subsetOfSumZero(arrA, j+1, sum+arrA[j], list);
            list.remove(list.size() - 1);
        }
    }
}
