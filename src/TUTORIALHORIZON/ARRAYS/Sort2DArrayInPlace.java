package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;

/**
 * Problem: Given a two-dimensional array where each individual row is sorted in ascending order. Your task to sort the entire 2d array in ascending order. Write an algorithm for the sorting.
 * <p>
 * Example:
 * <p>
 * Given Array:
 * [[5, 12, 17, 21, 23]
 * [1, 2, 4, 6, 8]
 * [12, 14, 18, 19, 27]
 * [3, 7, 9, 15, 25]]
 * <p>
 * Sorted Array:
 * [[1, 2, 3, 4, 5]
 * [6, 7, 8, 9, 12]
 * [12, 14, 15, 17, 18]
 * [19, 21, 23, 25, 27]]
 */

/*APPROACH
 * Given 2D array
 *  start from the first elem (0,0)
 *   search in the first column, the minimum and swap
 *   reorder the row from which min item was found
 *  move to next elem in row
 *   search in the first column, find the min and swap
 *   reorder the row from which min item was found
 *
 * repeat till all are ordered
 *
 */
public class Sort2DArrayInPlace {
    public static void main(String[] args) {
        int[][] input = {
                {5, 12, 17, 21, 23},
                {1, 2, 4, 6, 8},
                {12, 14, 18, 19, 27},
                {3, 7, 9, 15, 25}
        };

        int[][] result = sortInPlace(input);

        for (int [] row : result)
            System.out.println(Arrays.toString(row));
    }

    private static int[][] sortInPlace(int[][] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                searchAndSort(input, i, j, i + 1);
            }
        }
        return input;
    }

    private static void searchAndSort(int[][] input, int row, int col, int nextRow) {

        int current_elem = input[row][col];
        int found_index = -1;


        for (int i = nextRow; i < input.length; i++) {
            if (current_elem > input[i][0]) {
                found_index = i;
                current_elem = input[i][0];
            }
        }

        if(found_index == -1) return;

        input[row][col] = swap(input[found_index][0], input[found_index][0] = input[row][col]);

        Arrays.sort(input[found_index]);
    }

    private static int swap(int i, int j) {
        return i;
    }
}
