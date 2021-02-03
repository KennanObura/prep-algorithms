package kennan.co.ke.sortingAndSearching;

import java.util.Arrays;

public class SimpleMergeSort {
    public static void main(String[] args) {
        int[] elements = {96, 20, 63, 25, 28, 23, 10, 37, 87, 10, 6, 15, 66};

        mergeSort(elements);

        System.out.println(Arrays.toString(elements));
    }

    private static void mergeSort(int[] elements) {
        mergeSort(elements, 0, elements.length - 1);
    }

    private static void mergeSort(int[] elements, int start, int end) {
        if (start >= end) return;

        int mid = getMid(start, end);
        mergeSort(elements, start, mid);
        mergeSort(elements, mid + 1, end);

        merge(elements, start, mid, end);

    }



    private static void merge(int[] elements, int start, int mid, int end) {
        int[] temp = new int[elements.length];
        int tempIndex = start;
        int startIndex = start;
        int midIndex = mid + 1;

        //copy items into temp in natural ordering
        while (startIndex <= mid && midIndex <= end) {
            if (elements[startIndex] < elements[midIndex])
                temp[tempIndex++] = elements[startIndex++];
            else
                temp[tempIndex++] = elements[midIndex++];
        }

        //copy the remaining items into temp
        while (startIndex <= mid)
            temp[tempIndex++] = elements[startIndex++];

        while (midIndex <= end)
            temp[tempIndex++] = elements[midIndex++];

        //copy the entire temp back to original array
        for (int i = start; i <= end; i++)
            elements[i] = temp[i];

    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}
