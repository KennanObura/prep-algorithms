package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArray {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};

        String string = "125";

        ArrayList<int[]> res = permutations(num);
        for(int[] s : res)
            System.out.println(Arrays.toString(s));

//        List<int[]> result = new ArrayList<>();
//        generatePermutations(num, 0, result);
//
//        for (int[] item : result)
//            System.out.println(Arrays.toString(item));
    }




    private static void generatePermutations(int[] num, int index, List<int[]> result) {
        if (index == num.length - 1) {
            result.add(num);
            return;
        }
        generatePermutations(num, index + 1, result);
        for (int i = index+1; i < num.length; i++) {
            num[i] = swap(num[index], num[index] = num[i]);

            generatePermutations(num, index + 1, result);
            num[i] = swap(num[index], num[index] = num[i]);
        }

    }

    private static int swap(int i, int j) {
        return i;
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void permutations(int[] arr, int loc, int len, ArrayList<int[]> result) {
        if (loc == len) {
            result.add(arr);
            return;
        }

        for (int i = loc; i < len; i++) {
            // Swap the current arr[loc] to position i
            swap(arr, loc, i);
            permutations(arr, loc + 1, len, result);
            // Restore the status of arr to perform the next pick
            swap(arr, loc, i);
        }
    }

    public static ArrayList<int[]> permutations(int [] items) {
        ArrayList<int[]> result = new ArrayList<>();

        permutations(items, 0, items.length, result);
        return result;
    }

}
