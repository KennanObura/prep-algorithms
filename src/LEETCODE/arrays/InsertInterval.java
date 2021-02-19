package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 57. Insert Interval
 * Medium
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Example 3:
 * <p>
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 * Example 4:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 * Example 5:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};

        int[][] res = insert(intervals, newInterval);

//
        for (int[] it : res)
            System.out.println(Arrays.toString(it));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> result = new LinkedList<>();
        boolean firstFound = false;


        for (int[] interval : intervals) {
            if (newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) {
                interval[1] = Math.max(newInterval[1], interval[1]);
                result.addLast(interval);
                firstFound = true;
            }

            if (firstFound) {
                int[] lastItem = result.getLast();
                if (interval[0] > lastItem[0] && interval[0] <= lastItem[1])
                    result.getLast()[1] = Math.max(lastItem[1], interval[1]);
                continue;
            }
            result.addLast(interval);
        }

        if (!firstFound) {
            result.addLast(newInterval);
        }

        int[][] restArray = new int[result.size()][2];
        int i = 0;
        for (int[] interval : result)
            restArray[i++] = interval;

        return restArray;
    }
}
