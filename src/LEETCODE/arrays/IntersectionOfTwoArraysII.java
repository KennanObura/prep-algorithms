package LEETCODE.arrays;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * Easy
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 1, 2, 2, 2}, new int[]{2, 2, 1})));

        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2, 2})));

        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));

        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{1, 2, 1, 2, 2, 2})));


        System.out.println(Arrays.toString(intersectSorted(new int[]{1, 2, 1, 2, 2, 2}, new int[]{2, 2, 1})));

        System.out.println(Arrays.toString(intersectSorted(new int[]{1,2,2,1}, new int[]{2, 2})));

        System.out.println(Arrays.toString(intersectSorted(new int[]{4,9,5}, new int[]{9,4,9,8,4})));

        System.out.println(Arrays.toString(intersectSorted(new int[]{4,9,5}, new int[]{1, 2, 1, 2, 2, 2})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> list = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 0) {
                    list.add(i);
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list)
            result[i++] = num;

        return result;

    }

    /**
     *

     Follow up:

     What if the given array is already sorted? How would you optimize your algorithm?
     What if nums1's size is small compared to nums2's size? Which algorithm is better?
     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

     */

    public static int[] intersectSorted(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]) i++;
            else if(nums2[j] < nums1[i]) j++;
            else {
                list.add(nums1[i]);
                j++;
                i++;
            }
        }


        int[] result = new int[list.size()];
        int k = 0;
        for (int num : list)
            result[k++] = num;

        return result;

    }


}
