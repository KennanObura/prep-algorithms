package kennan.co.ke.arrays;

/**
 * Algorithm:
 * Starts with top right element, so initialise r=0 and c=
 * sortedMatrix[0].length-1
 * Iterate over matrix with boundary conditions.
 * If current element lets say m is equal to element X, return it.
 * If m < X, go left,so decrease column by 1 (c--).
 * If m > X, go right, so increase row by 1(r++).
 */
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] sortedMatrix =
                {
                        {1, 6, 10, 12, 20},
                        {4, 8, 15, 22, 25},
                        {5, 20, 35, 37, 40},
                        {10, 28, 38, 45, 55}
                };
        solve(sortedMatrix, 37);
    }

    private static void solve(int[][] matrix, int X) {
        solve(matrix, matrix[0].length - 1, 0, X);
    }

    private static void solve(int[][] matrix, int col, int row, int x) {
        if (row >= matrix.length || col < 0) return;

        if (matrix[row][col] == x)
            System.out.print("Found at " + row + "," + col);
        else if (x < matrix[row][col])
            solve(matrix, col - 1, row, x); //move left
        else
            solve(matrix, col, row + 1, x); //move down
    }
}
