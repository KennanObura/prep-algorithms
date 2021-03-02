package LEETCODE.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 719. Find K-th Smallest Pair Distance
 * Hard
 * <p>
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 * <p>
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 */
public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{1, 3, 4, 2}, 6));

    }

    public static int smallestDistancePair(int[] nums, int k) {
        int N = nums.length;
        /*
        - Maintain a max heap
        - calculate distance of pairs

        - push to queue while size less than k
        - pop while peek is more than current distance

        -
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int distance = Math.abs(nums[i] - nums[j]);
                if (queue.size() < k)
                    queue.add(distance);
                else {

                    if (!queue.isEmpty() && distance < queue.peek()) {
                        queue.poll();
                        queue.add(distance);
                    }

                }
            }

        }
        return queue.peek();
    }
}
