package kennan.co.ke.arrays;

import java.util.Arrays;

public class Sort0s1sAnd2s {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 0, 0, 1, 2, 2, 1};
        partitioningSolution(nums);
    }

    /*
     * A very basic approach to solve this problem can be keeping the count of number of zeroes,
     * ones and twos in the given array and then manipulate the given array in accordance with the frequency of every number.
     * This approach is a bit inspired by counting sort. No matter what the initial value of that particular index is, we first put all the zeroes we have in the array starting from index zero, then put all the ones and after that put all the twos.
     *
     * Steps:
     * 1.) Traverse the given array once and keep incrementing the count of the number encountered.
     * 2.) Now Traverse the array again starting from index zero and keep changing the value of the element on current
     * index first exhaust all the zeroes then ones and finally all the twos.
     *
     * This way we have a sorted array where all the zeroes are in starting followed by all the ones and
     * then in last section we have all the twos in a time complexity of O(n).
     */
    private static void solution(int[] array) {
        int[] frequency = new int[3];
        for (int i : array) frequency[i]++;

        int index = 0;
        for (int i = 0; i < frequency.length; i++) {
            int j = 0;
            while (j++ < frequency[i]) {
                array[index++] = i;
            }
        }

        System.out.println(Arrays.toString(array));
    }


    /* Another (OPTIMAL) solution is to use Dutch national flag algorithm or Three way partitioning in which elements of similar type are
    grouped together and their collective groups are also sorted in a the correct order.
     *  Init 3 pointers, low, mid and high.
     *  loop till mid meets high , swapping elements in their right positions
     *  https://java2blog.com/sort-array-of-0s-1s-and-2s/
     */

    private static void partitioningSolution(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            if (array[mid] == 0) {
                array[low] = swap(array[mid], array[mid] = array[low]);
                mid++;
                low++;
            } else if (array[mid] == 2) {
                array[high] = swap(array[mid], array[mid] = array[high]);
                high--;
            } else mid++;
        }
        System.out.println(Arrays.toString(array));
    }

    private static int swap(int i, int j) {
        return i;
    }
}
