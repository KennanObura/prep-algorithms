package LEETCODE.arrays;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {

        List<List<Integer>> result = subsets(new int[]{4,4,4,1,4});
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> listSet = new HashSet<>();
        subset(nums, 0, listSet, new ArrayList<>());
        return new ArrayList<>(listSet);
    }


    private static void subset(int[] nums, int indx, Set<List<Integer>> listSet, List<Integer> internal) {

        if (indx == nums.length) {
            listSet.add(new ArrayList<>(internal));
            return;
        }


        if (indx > nums.length) return;

        internal.add(nums[indx]);
        subset(nums, indx + 1, listSet, internal);
        internal.remove(internal.size() - 1);
        subset(nums, indx + 1, listSet, internal);

    }
}
