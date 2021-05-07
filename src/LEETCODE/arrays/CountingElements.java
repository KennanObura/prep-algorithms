package LEETCODE.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 1426. Counting Elements
 * Easy
 * <p>
 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * <p>
 * Example 3:
 * <p>
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * <p>
 * Example 4:
 * <p>
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 * <p>
 * Example 5:
 * <p>
 * Input: arr = [1,1,2]
 * Output: 2
 * Explanation: Both 1s are counted because 2 is in the array.
 */
public class CountingElements {
    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
        System.out.println(countElements(new int[]{1, 2, 3}));
        System.out.println(countElements(new int[]{1, 3, 2, 3, 5, 0}));
        System.out.println(countElements(new int[]{1, 1, 2, 2}));
        System.out.println(countElements(new int[]{1, 1, 2}));
    }

    private static int countElements(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int i : arr)
            set.add(i);

        int count = 0;
        for (int i : arr)
            if (set.contains(i + 1)) count++;

        return count;

    }
}
