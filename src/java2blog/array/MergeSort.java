package java2blog.array;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 6, 3, 3, 7, 5};
        mergeSort(nums);

        System.out.println(Arrays.toString(nums));
    }


    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        int i = start;

        int leftIndex = start;
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex])
                temp[i++] = nums[leftIndex++];
            else
                temp[i++] = nums[rightIndex++];
        }


        while (leftIndex < mid + 1)
            temp[i++] = nums[leftIndex++];

        while (rightIndex < end + 1)
            temp[i++] = nums[rightIndex++];

        for (int j = start; j <= end; j++) {
            nums[j] = temp[j];
        }

    }
}
