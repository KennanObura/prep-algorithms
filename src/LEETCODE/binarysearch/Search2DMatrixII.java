package LEETCODE.binarysearch;

/*
240. Search a 2D Matrix II
Medium

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 */
public class Search2DMatrixII {
    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 5));

        System.out.println(searchMatrix(matrix, 20));

        int[][] matrix2 = {{1, 1}};
        System.out.println(searchMatrix(matrix2, 2));

    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        /*
        - Since row and cols are sorted, we can apply binary search
        let start be 0 (row)
            end be colLength-1 (col)
            let elem be element at start and end
            if target < elem at start
                decrement end (col)
            if target > elem
                increment start
            if target == elem
                return true

         */

        int row = 0, col = colLength - 1;

        while (row < rowLength && col >= 0) {
            int elem = matrix[row][col];

            if (elem == target)
                return true;
            else if (elem > target)
                col--;
            else
                row++;

        }

        return false;

    }


}
