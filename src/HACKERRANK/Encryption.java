package HACKERRANK;

import java.util.Arrays;

public class Encryption {
    public static void main(String[] args) {
        String s1 = "feedthedog";
        String s2 = "haveaniceday";
        String s3 = "chillout";
        System.out.println(encryption(s1));
        System.out.println(encryption(s2));
        System.out.println(encryption(s3));
    }

    static String encryption(String s) {
        String newString = s.replaceAll("\\s+", "");

        int row = (int) Math.floor(Math.sqrt(newString.length()));
        int col = (int) Math.ceil(Math.sqrt(newString.length()));

        row = row * col >= newString.length() ? row : row + 1;

        char[][] matrix = new char[row][col];

        int ind = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ind > newString.length() - 1)
                    break;
                matrix[i][j] = newString.charAt(ind++);
            }
        }

        StringBuilder builder = new StringBuilder();
//
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++)
                if (matrix[i][j] > 0)
                    builder.append(matrix[i][j]);

            if (j < col - 1)
                builder.append(" ");
        }
        return builder.toString();
    }

}
