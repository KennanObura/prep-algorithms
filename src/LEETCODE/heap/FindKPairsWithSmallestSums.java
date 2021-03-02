package LEETCODE.heap;

import java.util.*;

/*
373. Find K Pairs with Smallest Sums
Medium

1813

125

Add to List

Share
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence:
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {

        System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        /*
        - Maintain priority queue with custom comparator comparing pair sum


        for i = 0 ... N
            for j = 0 ... M
                let pair = elems at i and j
                add to queue

        poll the first k elems to list
        return list
         */

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return getSum(o1) - getSum(o2);
            }
        });

        for (int i : nums1)
            for (int j : nums2)
                queue.add(Arrays.asList(i, j));


        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty() && k > 0) {
            result.add(queue.poll());
            k--;
        }
        return result;
    }

    private static int getSum(List<Integer> pair) {
        return pair.get(0) + pair.get(1);
    }

}
