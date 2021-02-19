package LEETCODE.arrays;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[]a = {1,2,2,0,0,1,2,2,1};
        int[]colors = {0};
        sortColors(a);
        sortColors(colors);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(colors));
    }

    private static void sortColors(int[] nums) {

        int start = 0, mid = 0;
        int end = nums.length - 1;


        while (mid <= end) {
            int current = nums[mid];
            if (current == 0)
                nums[start] = swap(nums[mid], nums[mid++] = nums[start++]);
            else if (current == 1)
                mid++;
            else
                nums[end] = swap(nums[mid], nums[mid] = nums[end--]);
        }

    }

    private static int swap(int num, int i) {
        return num;
    }
}
