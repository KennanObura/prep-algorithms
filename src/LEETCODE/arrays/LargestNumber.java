package LEETCODE.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: "1"
 * Example 4:
 * <p>
 * Input: nums = [10]
 * Output: "10"
 */
public class LargestNumber {
    public static void main(String[] args) {

        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{999999991, 9}));

        System.out.println(largestNumber(new int[]{0, 0, 0}));
    }

    public static String largestNumber(int[] nums) {
        int N = nums.length;
        String[] stringNums = new String[N];
        int i = 0;
        for (int num : nums)
            stringNums[i++] = String.valueOf(num);

        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String A = a + b;
                String B = b + a;
                return A.compareTo(B) > 0 ? -1 : 1;
            }
        });

        StringBuilder st = new StringBuilder();

        for (String s : stringNums)
            st.append(s);

        int k = 0; // search for preceeding zeros
        while (k < st.length() && st.charAt(k++) == '0')
            k++;

        if(k > 1) // if preceeding zeror are found, return the last
            return st.substring(st.length()-1);

        return String.valueOf(st);
    }
}
