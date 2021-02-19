package LEETCODE.arrays;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Medium
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] res = topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2);

        System.out.println(Arrays.toString(res));
    }

    private static class Elem {
        int val, freq;


        Elem(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }


    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);


        Queue<Integer> queue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
            if (queue.size() > k) queue.poll();
        }

        int[] result = new int[k];
        int i = 0;
        for (Integer elem : queue)
            result[i++] = elem;

        return result;
    }
}
