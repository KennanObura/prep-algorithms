package LEETCODE.arrays;

/*
Share
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.



Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
 */
public class SumOfDiagonal {


    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] mat2 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int[][] mat3 = {
                {5}
        };
        System.out.println(diagonalSum(mat));
        System.out.println(diagonalSum(mat2));
        System.out.println(diagonalSum(mat3));
    }


    public static int diagonalSum(int[][] mat) {

        int M = mat.length;

        if (M == 1) return mat[0][0];

        int N = M - 1;

        int sum = 0;
        for (int i = 0; i <= N; i++) {
            sum += mat[i][i];
            if (M % 2 != 0 && i == N / 2) continue;
            sum += mat[i][N - i];
        }
        return sum;
    }
}
