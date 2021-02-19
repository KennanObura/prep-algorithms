package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ContainDuplicatesIII {
    public static void main(String[] args) {

        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));

        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));

        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }


    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int N = nums.length;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            Long ceil = set.floor((long) nums[i]);
            double floor = Math.floor((double) nums[i]);
            System.out.println(ceil + "|" + floor);

        }

        return false;

    }

    public static boolean containsNearbyAlmostDuplicateNaive(int[] nums, int k, int t) {

        int N = nums.length;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (Math.abs(nums[i] - nums[j]) <= t && j - i <= k) {
                    return true;
                }

            }
        }

        return false;

    }
}
