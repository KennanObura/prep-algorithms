package GEEKFORGEEKS.dynamicPrograming;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which
 * the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * He can move only (right->,right up /,right down\) that is from a given cell,
 * the miner can move to the cell diagonally up towards the right or right or diagonally down
 * towards the right. Find out maximum amount of gold he can collect.
 * <p>
 * Examples:
 * <p>
 * Input : mat[][] = {{1, 3, 3},
 * {2, 1, 4},
 * {0, 6, 4}};
 * Output : 12
 * {(1,0)->(2,1)->(2,2)}
 * <p>
 * Input: mat[][] = { {1, 3, 1, 5},
 * {2, 2, 4, 1},
 * {5, 0, 2, 3},
 * {0, 6, 1, 2}};
 * Output : 16
 * (2,0) -> (1,1) -> (1,2) -> (0,3) OR
 * (2,0) -> (3,1) -> (2,2) -> (2,3)
 * <p>
 * Input : mat[][] = {{10, 33, 13, 15},
 * {22, 21, 04, 1},
 * {5, 0, 2, 3},
 * {0, 6, 14, 2}};
 * Output : 83
 */
public class GoldMineProblem {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };

        System.out.println(maximumGold(mat));

    }

    private static int maximumGold(int[][] matrix) {

        int maximumA = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            int currentAmount = maximumGold(matrix, row, 0);
            maximumA = Math.max(maximumA, currentAmount);
//            System.out.println(currentAmount);
        }
        return maximumA;
    }

    private static int maximumGold(int[][] matrix, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0)
            return 0;


        int moveRight = maximumGold(matrix, row, col + 1) + matrix[row][col];
        int moveRightUp = maximumGold(matrix, row + 1, col + 1) + matrix[row][col];
        int moveRightDown = maximumGold(matrix, row - 1, col + 1) + matrix[row][col];

        return Math.max(moveRight, Math.max(moveRightUp, moveRightDown));
    }


}
