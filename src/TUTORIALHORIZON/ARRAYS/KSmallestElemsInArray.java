package TUTORIALHORIZON.ARRAYS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Objective: Given an array of integers, write an algorithm to find the three smallest elements in the array.
 * <p>
 * Example:
 * <p>
 * Int [] a = { 6, 8, 1, 9, 2, 10};
 * Output: 1, 2, 6
 * Int [] a = { 6, 8, 1, 9, 2, 1, 10, 10};
 * Output: 1, 1, 2
 * Int [] a = {6};
 * Output: Invalid Input, array size is less than 3
 * <p>
 * <p>
 * APPROACH
 * priority queue
 */
public class KSmallestElemsInArray {
    public static void main(String[] args) {
        int[] a = {6, 8, 1, 9, 2, 10};

        smallestElements(a, 3);
    }

    private static void smallestElements(int[] elements, int k) {
        Queue<Integer> queue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }.reversed());


        for (int item : elements) {
            if (queue.size() == k && queue.peek().compareTo(item) > 0)
                queue.poll();
            else if (queue.size() < k)
                queue.add(item);
        }

        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
