package GEEKFORGEEKS.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * <p>
 * Difficulty Level : Hard
 * Last Updated : 06 Apr, 2021
 * <p>
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * Example:
 * <p>
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumPartitionsTopDown {
    public static void main(String[] args) {
        System.out.println(minimumPartitions(new int[]{1, 6, 11, 5}));
        System.out.println(minimumPartitions(new int[]{1, 2, 7}));
        System.out.println(minimumPartitions(new int[]{15, 7, 9, 2, 5, 10}));
    }

    private static int minimumPartitions(int[] A) {

        int N = A.length, leftSet = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i : A)
            leftSet += i;

        return minimumPartitions(A, N - 1, leftSet, 0, map);

    }

    private static int minimumPartitions(int[] A, int index, int leftSet, int rightSet,  Map<String, Integer> map ) {
        if (index == 0) {
            return Math.abs(leftSet - rightSet);
        }

        String key = index + "|" + rightSet;

        if(!map.containsKey(key)) {
            int toRightSum = minimumPartitions(A, index - 1, leftSet - A[index], rightSet + A[index], map);
            int toLeftSum = minimumPartitions(A, index - 1, leftSet, rightSet, map);
            map.put(key, Math.min(toLeftSum, toRightSum));
        }
        return map.get(key);
    }
}
