package LEETCODE.MSPRO;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 179. Largest Number
 * Medium
 * <p>
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: "1"
 * <p>
 * Example 4:
 * <p>
 * Input: nums = [10]
 * Output: "1
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{999999991, 9}));
        System.out.println(largestNumber(new int[]{0, 0, 1}));
        System.out.println(largestNumber(new int[]{0, 0, 0}));
    }

    public static String largestNumber(int[] nums) {

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String A = a + b;
                String B = b + a;
                return B.compareTo(A);
            }
        });

        for (int i : nums)
            queue.add(String.valueOf(i));

        StringBuilder result = new StringBuilder();
        boolean digitSeen = false;

        while (!queue.isEmpty()) {
            if (!digitSeen && queue.peek().equals("0")) {
                queue.poll();
                continue;
            }

            if (!queue.peek().equals("0"))
                digitSeen = true;

            result.append(queue.poll());
        }


        return result.length() == 0 ? "0":  String.valueOf(result);

    }
}
