package LEETCODE.arrays;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * Easy
 * <p>
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * <p>
 * Example 4:
 * <p>
 * Input: grid = [[-1]]
 * Output: 1
 */
public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {

        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        int[][] grid2 = {{2, -1}, {-1, -1}};

        System.out.println(countNegatives(grid));
        System.out.println(countNegatives(grid2));

    }

    public static int countNegatives(int[][] grid) {

        int count = 0;

        for (int[] ints : grid) {
            int M = grid[0].length - 1;
            while (M >= 0 && ints[M] < 0) {
                M--;
                count++;
            }
        }
        return count;
    }
}
