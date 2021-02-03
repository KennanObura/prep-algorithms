package kennan.co.ke.sortingAndSearching;

import java.util.Arrays;

public class SortImp {
    public static void main(String[] args) {

        int[] array = {96, 20, 63, 25, 25, 20};
        System.out.println(Arrays.toString(selectionSort(array)));

    }

    private static int[] bubbleSort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[j] > items[i])
                    items[i] = swap(items[j], items[j] = items[i]);
            }
        }
        return items;
    }

    private static int[] selectionSort(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int minIndex = i; //scan for elem, store its index
            for (int j = i + 1; j < items.length; j++)
                if (items[j] < items[minIndex])
                    minIndex = j;

            if (minIndex > i)
                items[i] = swap(items[minIndex], items[minIndex] = items[i]);
        }
        return items;
    }

    private static int swap(int j, int i) {
        return j;
    }


}
