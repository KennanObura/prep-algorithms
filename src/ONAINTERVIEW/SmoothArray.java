package ONAINTERVIEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * An array of integers a is called smooth if the absolute value of the difference between any two adjacent elements is less than or equal to 1. You are given an array a. Check whether it is smooth and output "YES" if it is, or "NO" if it is not (quotes for clarity only).
 * <p>
 * The first line of the input contains an integer N - the number of elements in the array. 1 <= N <= 10.
 * The second line of the input contains N integers - the elements of the array, separated with single spaces. 1 <= ai <= 10.
 * <p>
 * Example
 * <p>
 * input
 * <p>
 * 5
 * 3 4 4 5 4
 * <p>
 * output
 * <p>
 * YES
 * <p>
 * input
 * <p>
 * 4
 * 1 1 8 2
 * <p>
 * output
 * NO
 */
public class SmoothArray {
    public static void main(String[] args) throws IOException {
        int[] nums = {3, 4, 4, 5, 4};
        int[] nums2 = {1, 1, 8, 2};
//        smoothArray(nums);
//        smoothArray(nums2);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); //Length of Array
        String s = br.readLine(); //Input the number seperated by space
        int[] arr = new int[num];
        String[] s1 = s.split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }


        smoothArray(arr);
//        smoothArray(nums2);
    }


    private static void smoothArray(int[] nums) {
        if (smoothArrayUtil(nums)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean smoothArrayUtil(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (Math.abs(nums[i - 1] - nums[i]) > 1) return false;
        return true;
    }
}
