package RANDOM;

import java.util.Arrays;

/**
 * Given an array of integers, you are allowed to swap only adjacent elements in the array. write a program to find the minimum number of swaps to sort the given array.
 * <p>
 * Example:
 * <p>
 * Input[] : [2, 20, 15, 6, 10]
 * Minimums adjacent swaps required sort the array: 5
 * <p>
 * Input[] : [10, 3, 4, 2, 5, 7, 9, 11]
 * Minimums adjacent swaps required sort the array: 8
 */
public class MinimumNumberOfAdjacentSwaps {
    public static void main(String[] args) {

        System.out.println(numberOfSwaps(new int[]{10, 3, 4, 2, 5, 7, 9, 11}));
    }


    /*
    Naive O(N^2)
     */
    private static int numberOfSwaps(int[] nums) {
        int N = nums.length;
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                if (nums[j - 1] > nums[j]) {
                    nums[j - 1] = swap(nums[j], nums[j] = nums[j - 1]);
                    count++;
                }


            }
        }
        return count;
    }

    private static int swap(int num, int i) {
        return num;
    }


    private static int numberOfSwapsBinarySearch(int[] nums) {
        int N = nums.length;
        int count = 0;


        for (int i = N - 1; i > 0; i--) {
            if(nums[i-1] > nums[i])
                count++;
//                int index = doBinarySearch(nums, i-1);

        }


        return count;
    }

//    private static int doBinarySearch(int[] nums, int i) {
//        Arrays.binarySearch()
//    }
}
