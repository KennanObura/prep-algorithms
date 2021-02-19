package LEETCODE.string;

import java.util.Arrays;

/**
 * 6. ZigZag Conversion
 * Medium
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;


        System.out.println(convert(s, numRows));

        System.out.println(convert(s, 4)); //PINALSIGYAHRPI

        System.out.println(convert("AB", 2)); //AB
    }

    public static String convert(String s, int numRows) {
        int K = s.length();

        if (s.isEmpty()) return "";
        if (K == 1 || numRows == 1) return s;

        int columnLength = 1000 / numRows;
        char[][] grid = new char[numRows][columnLength];

        grid[0][0] = s.charAt(0);

        fillGrid(s, grid, 0, 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] col : grid) {
            for (char i : col)
                if (i != 0)
                    stringBuilder.append(i);

        }


        return String.valueOf(stringBuilder);

    }

    private static void fillGrid(String s, char[][] grid, int col, int index) {

        int N = grid.length;
        int M = grid[0].length;
        int K = s.length();

        if (index >= K) return;

        int i = 1;


        while (index < K && i < N) {
            grid[i++][col] = s.charAt(index++);
        }

        --i;
        --index;
        int j = col;
        while (index < K && i >= 0 && j < M) {
            grid[i--][j++] = s.charAt(index++);
        }

        j--;

        fillGrid(s, grid, j, index);
    }
}
