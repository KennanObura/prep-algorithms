package LEETCODE.arrays;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {

        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        wiggleSort(nums2);


//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(nums2));
    }

    public static void  wiggleSort(int[] nums) {

        int N = nums.length;
        Arrays.sort(nums);

        int[] result = new int[N];

        int i = 1;
        int j = N-1;
        while (i < N) {
            result[i] = nums[j--]; //place larger items from sorted at odd positions
            i += 2;
        }
        i = 0;

        while (i < N) {
            result[i] = nums[j--]; //place the rest
            i += 2;
        }
        nums = Arrays.copyOf(result, nums.length);
//        for (int k = 0; k < N ; k++)
//            nums[k] = result[k];

        System.out.println(Arrays.toString(nums));

    }

    private static int swap(int num, int i) {
        return num;
    }
}
