package kennan.co.ke.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfJumpsToEnd {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 1, 0, 2, 0};
        int[] nums1 = {3,3,2,1,2};
        List<Integer> list = Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new));
        System.out.println(solve(list) + " so");
    }

    private static int solve(int[] array) {

        int i = 0;
        int jumps = 0;
        while (i < array.length) {
            i += array[i];
            jumps++;

            if (i < array.length && array[i] == 0) return -1;
        }

        return jumps;
    }


    private static int solve(List<Integer> list) {

        int i = 0;
        int jumps = 0;
        while (i < list.size()) {
            i += list.get(i);
            jumps++;

            if (i < list.size() && list.get(i) == 0) return -1;
        }

        return jumps;
    }
}
