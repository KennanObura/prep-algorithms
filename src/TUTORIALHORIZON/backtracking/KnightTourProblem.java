package TUTORIALHORIZON.backtracking;

import java.util.Arrays;

public class KnightTourProblem {
    public static void main(String[] args) {

        Board board = new Board(8);
        board.findPath();
        board.print();
    }

}

class Board {
    private final int[][] matrix;
    private final int N;
    private int PATH = 0;

    Board(int N) {
        this.matrix = new int[N][N];
        this.N = N;
    }


    public void findPath() {
        findPath(0, 0, 0);
    }

    public void print() {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private boolean findPath(int row, int col, int index) {
        if (index == N * N - 1) return true;


        if (row < 0 || row >= N || col < 0 || col >= N || matrix[row][col] != 0) return false;


        matrix[row][col] = PATH++;

        if (findPath(row + 2, col + 1, index + 1)) return true;


        if (findPath(row + 2, col - 1, index + 1)) return true;

        if (findPath(row - 2, col + 1, index + 1)) return true;

        if (findPath(row - 2, col - 1, index + 1)) return true;

        if (findPath(row + 1, col + 2, index + 1)) return true;

        if (findPath(row - 1, col + 2, index + 1)) return true;

        if (findPath(row + 1, col - 2, index + 1)) return true;

        if (findPath(row - 1, col - 2, index + 1)) return true;


        PATH--;
        matrix[row][col] = 0;
        return false;
    }
}
