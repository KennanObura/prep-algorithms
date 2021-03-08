package LEETCODE.arrays;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};

        int[] A = {4, 9, 5}, B = {9, 4, 9, 8, 4};

        System.out.println(intersect(nums1, nums2));

        System.out.println(intersect(A, B));

    }

    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int M = nums2.length;

        Set<Integer> set = new LinkedHashSet<>();
        for (int item : nums2)
            set.add(item);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int target = nums1[i];
            if (set.contains(target)) {
                List<Integer> list = linearScan(nums1, i, set);

                if (list.size() > result.size())
                    result = list;
            }
        }
        return result;
    }

    private static List<Integer> linearScan(int[] nums1, int i, Set<Integer> set) {
        Iterator<Integer> it = set.iterator();
        List<Integer> result = new ArrayList<>();
        int item = -1;
        while (it.hasNext()) {
            item = it.next();
            while (i < nums1.length && item == nums1[i]) {
                result.add(item);
                i++;
            }
        }


//        while (it.hasNext() && i < nums1.length) {
//            item = it.next();
//            if (item != nums1[i])
//                break;
//            i++;
//            result.add(item);
//        }

        return result;

    }
}
