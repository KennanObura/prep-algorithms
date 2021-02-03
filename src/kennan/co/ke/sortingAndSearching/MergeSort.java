package kennan.co.ke.sortingAndSearching;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] elements = {96, 20, 63, 25, 25, 20};
        System.out.println(Arrays.toString(mergeSort(elements)));
    }

    private static int[] mergeSort(int[] elements) {
        /*
         * 1. Divide elements into halves till elem in array remain 1.
         * 2. Merge items back by comparing them and placing to right ordering
         *      - create a temp array,
         *      - copy arrays to temp, while comparing, and keeping track of start, end
         *      - copy back to original array
         *
         */
        int start = 0;
        int end = elements.length - 1;
        int[] temp = new int[elements.length + 1];
        mergeSort(elements, temp, start, end);
        return elements;
    }

    private static void mergeSort(int[] elements, int[] temp, int start, int end) {
        if (start >= end) return;
        int mid = getMid(start, end);
        mergeSort(elements, temp, start, mid);
        mergeSort(elements, temp, mid + 1, end);
        merge(elements, temp, start, end, mid);
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    private static void merge(int[] elements, int[] temp, int start, int end, int mid) {
        if (end + 1 - start >= 0) System.arraycopy(elements, start, temp, start, end + 1 - start);


        int i = start;
        int j = mid + 1;
        int current = start;

        while (i <= mid && j <= end) {
            if (temp[i] <= temp[j])
                elements[current++] = temp[i++];
            else
                elements[current++] = temp[j++];

        }

        int remaining = mid - i;
        if (remaining + 1 >= 0) System.arraycopy(temp, i, elements, current, remaining + 1);
    }

}
