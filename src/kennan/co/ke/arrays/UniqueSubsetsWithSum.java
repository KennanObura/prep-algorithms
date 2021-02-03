package kennan.co.ke.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsetsWithSum {
    private static List<ArrayList<Integer>> result;

    public static void main(String[] args) {

        int[] numbers = {2, 6, 3, 5};
        int n = 8;

        Arrays.sort(numbers);

        result = new ArrayList<>();
        getSetsOfNumbers(numbers, n);

        for (ArrayList<Integer> list : result)
            System.out.println(list);
    }

    private static void getSetsOfNumbers(int[] numbers, int n) {
        combinationUtil(numbers, n, 0, 0, new ArrayList<>());
    }


    public static ArrayList<Integer> combinationUtil(int[] arrA, int sum, int currSum, int startIndex, ArrayList<Integer> combinationList) {

        if (currSum == sum) {
            return combinationList;
        }

        for (int i = startIndex; i < arrA.length; i++) {

            if (currSum + arrA[i] > sum) //array is sorted, no need to check further
                break;
            combinationList.add(arrA[i]);
            combinationUtil(arrA, sum, currSum + arrA[i], i, combinationList);
            combinationList.remove(combinationList.size() - 1);
        }

        return combinationList;
    }
}
