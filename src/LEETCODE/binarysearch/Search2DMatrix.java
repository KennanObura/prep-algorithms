package LEETCODE.binarysearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class Search2DMatrix {
    public static void main(String[] args) {

        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int [][] matrix2 = {{1,1}};

        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix2, 13));



    }

    private static boolean searchMatrix(int[][] matrix, int target) {

        int N = matrix.length;
        int M = matrix[0].length;

        int row = 0, col = M - 1;

        while (row < N && col >= 0) {
            int elem = matrix[row][col];

            if (elem == target) return true;
            else if (target < elem)
                col--;
            else row++;
        }
        return false;
    }
}
