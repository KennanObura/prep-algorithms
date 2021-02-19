package java2blog.array;

import java.util.Arrays;

public class InsersionSort {
    public static void main(String[] args) {

        int [] nums = {12, 3, 1, 11, 6, 5};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            int j = i-1;

            while (j >= 0 && nums[j] > temp)
                nums[j+1] = nums[j--];

            nums[j+1] = temp;
        }
    }
}
