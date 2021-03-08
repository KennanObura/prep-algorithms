package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Given an array of numbers, write a program to rank the array elements.
 * <p>
 * Example:
 * <p>
 * Given array: [22, 11, 44, 66, 55]
 * Rank: [2, 1, 3, 5, 4]
 * <p>
 * Given array: [15, 12, 11, 10, 9]
 * Rank: [5, 4, 3, 2, 1]
 * <p>
 * Given array: [10, 20, 30, 40, 50]
 * Rank: [1, 2, 3, 4, 5]
 * <p>
 * Given array: [10, 10, 10, 10, 20]
 * Rank: [1, 1, 1, 1, 2]
 */
public class RankArrayElements {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(rankArrayElems(new int[]{22, 11, 44, 66, 55})));
        System.out.println(Arrays.toString(rankArrayElems(new int[]{15, 12, 11, 10, 9})));
        System.out.println(Arrays.toString(rankArrayElems(new int[]{10, 20, 30, 40, 50})));
        System.out.println(Arrays.toString(rankArrayElems(new int[]{10, 10, 10, 10, 20})));
        System.out.println(Arrays.toString(rankArrayElems(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));

        System.out.println(Arrays.toString(rankArrayElems(new int[]{})));


    }

    private static int[] rankArrayElems(int[] nums) {
        int N = nums.length;


        TreeSet<Integer> set = new TreeSet<>(); //nlogk
        for (int i : nums)
            set.add(i);

        ArrayList<Integer> list = new ArrayList<>(set);

        int[] ranks = new int[N];
        for (int i = 0; i < N; i++) {
            ranks[i] = list.indexOf(nums[i]) + 1;
        }
        return ranks;
    }
}
