package LEETCODE.arrays;

import java.util.*;

/**
 * 56. Merge Intervals
 * Medium
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlappin
 */
public class MargeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] res = merge(intervals);
//        int[][] re2 = merge(intervals2);
//
        for (int[] it : res)
            System.out.println(Arrays.toString(it));

//        for (int[] it : re2)
//            System.out.println(Arrays.toString(it));

    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0])
                result.add(interval);
            else
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);

        }


        int[][] newIntervals = new int[result.size()][2];
        int count = 0;
        for (int[] res : result)
            newIntervals[count++] = res;

        return newIntervals;
    }
}
