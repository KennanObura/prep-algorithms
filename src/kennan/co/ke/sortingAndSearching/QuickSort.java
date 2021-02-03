package kennan.co.ke.sortingAndSearching;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] elements = {96, 20, 63, 25, 28, 23, 10, 37, 87, 10, 6, 15, 66};

        doQuickSort(elements);

        System.out.println(Arrays.toString(elements));
    }

    private static void doQuickSort(int[] elements) {
        doQuickSort(elements, 0, elements.length - 1);
    }

    private static void doQuickSort(int[] elements, int start, int end) {
        int i = start;
        int j = end;

        int pivot = elements[getMid(start, end)];

        while (i <= j) {
            while (elements[i] < pivot)
                i++;

            while (elements[j] > pivot)
                j--;

            if (i <= j) {
                elements[i] = swap(elements[j], elements[j] = elements[i]);
                i++;
                j--;
            }
        }

        if(start < j)
            doQuickSort(elements, start, j);
        if(end > i)
            doQuickSort(elements, i, end);
    }

    private static int swap(int element, int i) {
        return element;
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }


}
