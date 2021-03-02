package LEETCODE.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * Medium
 * <p>
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * Example 2:
 * <p>
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 */
public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        };

        int[][] mat2 = {
                {1}
        };

        System.out.println(kthSmallest(mat, 8));

        System.out.println(kthSmallest(mat2, 1));

    }


    static int kthSmallest(int[][] matrix, int k) {
        /*
        - Maintain a maxHeap
        - iterate through the matrix and keep putting to heap while size less than k
        - if size exceeds k and the current item is less than the, pop and push the current item

        - let maxHeap be heap to maintain current k items
        for row = 0 ... N
            for col = 0 .. N
                let i = elem at row, col
                if heap.size < k
                    push i
                else
                    if i < heap.peek
                    pop from heap
                    push i



         */

        int N = matrix.length;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int[] row : matrix)
            for (int col = 0; col < N; col++) {
                if (queue.size() < k)
                    queue.add(row[col]);
                else {
                    if (!queue.isEmpty() && queue.peek() > row[col]) {
                        queue.poll();
                        queue.add(row[col]);
                    }
                }

            }

        return queue.peek();
    }
}
