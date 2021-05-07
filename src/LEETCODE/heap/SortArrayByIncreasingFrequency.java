package LEETCODE.heap;

import java.util.*;

/**
 * 1636. Sort Array by Increasing Frequency
 * Easy
 * <p>
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 * <p>
 * Return the sorted array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 */
public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));

        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));

        System.out.println(Arrays.toString(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));


        System.out.println("-----------------------------------------------------------------------");

        System.out.println(Arrays.toString(frequencySortUsingTreeMap(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));

        System.out.println(Arrays.toString(frequencySortUsingTreeMap(new int[]{2, 3, 1, 3, 2})));

        System.out.println(Arrays.toString(frequencySortUsingTreeMap(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));



    }


    /*


    Using hashmap for frequency and priority queue

    Accepted in Leetcode judge with 55% faster

    - Apparently this seems slower, due comparators i suppose
    - We can try it with TreeMaps and see how it goes
     */
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int compared = map.get(b).compareTo(map.get(a)) * -1;
                if (compared == 0)
                    return b.compareTo(a);
                return compared;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.add(entry.getKey());

        int i = 0;

        while (!queue.isEmpty()) {
            int item = queue.poll();
            int value = map.get(item);

            while (value > 0) {
                nums[i++] = item;
                value--;
            }
        }

        return nums;
    }


    public static int[] frequencySortUsingTreeMap(int[] nums) {
        /*
        1
        - Create a tree map., map We need it for natural ordering, but since the problem states that  "If multiple values have the same frequency, sort them in decreasing order."
        - In order to pre-sort the occurrences in decreasing order we need to reverse the ordering (reverse natural ordering)

        2
        - Create another treemap, groupMap, to maintain the frequencies from map above against Keys, keys as a list since multiple keys will have same frequencies (freq, keys)
         */
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        TreeMap<Integer, List<Integer>> groupMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            groupMap.put(entry.getValue(), groupMap.getOrDefault(entry.getValue(), new ArrayList<>()));
            groupMap.get(entry.getValue()).add(entry.getKey()); //append map key to the groupmap list
        }


        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : groupMap.entrySet()) {

            int frequency = entry.getKey();
            List<Integer> list = entry.getValue();

            for (int num : list) {
                int count = frequency;
                while (count > 0) {
                    nums[i++] = num;
                    count--;
                }
            }
        }


        return nums;
    }
}
