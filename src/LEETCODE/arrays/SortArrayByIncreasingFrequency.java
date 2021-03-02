package LEETCODE.arrays;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));

        System.out.println(Arrays.toString(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    public static int[] frequencySort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.equals(o2) ? map.get(o2) - (map.get(o1)) : map.get(o1) - (map.get(o2));
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.add(entry.getKey());

        int[] res = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            int item = queue.poll();
            int size = map.get(item);
            while (size > 0) {
                res[i++] = item;
                size--;
            }
        }
        return res;
    }
}
