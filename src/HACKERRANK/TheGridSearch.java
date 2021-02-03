package HACKERRANK;

public class TheGridSearch {
    public static void main(String[] args) {

        String[] grid = {
                "1234567890",
                "0987654321",
                "1111111111",
                "1111111111",
                "2222222222"
        };


        String[] pat = {
                "876543",
                "111111",
                "111111"
        };
        String[] grid2 = {
                "7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"
        };

        String[] pat2 = {
                "9505",
                "3845",
                "3530"
        };

        String[] grid3 = {
                "400453592126560",
                "114213133098692",
                "474386082879648",
                "522356951189169",
                "887109450487496",
                "252802633388782",
                "502771484966748",
                "075975207693780",
                "511799789562806",
                "404007454272504",
                "549043809916080",
                "962410809534811",
                "445893523733475",
                "768705303214174",
                "650629270887160"
        };

        String[] pat3 = {
                "99",
                "99"
        };

        System.out.println(gridSearch(grid, pat));

    }

    static String gridSearch(String[] G, String[] P) {

        char[][] matrix = new char[G.length][G[0].length()];
        char[][] pat = new char[P.length][P[0].length()];

        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[0].length(); j++)
                matrix[i][j] = G[i].charAt(j);
        }

        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P[0].length(); j++)
                pat[i][j] = P[i].charAt(j);
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == pat[0][0]) {
                    if (isCompletePattern(matrix, pat, i, j))
                        return "YES";
                }


            }
        }

        return "NO";
    }

    private static boolean isCompletePattern(char[][] matrix, char[][] pat, int row, int col) {
        for (char[] patRow : pat) {
            int i = 0;
            while (i < pat.length && col < matrix[0].length) {
                System.out.println(patRow[i] + "|" + matrix[col][row]);
                if (patRow[i] != matrix[col][row])
                    return false;
                i++;
                row++;
            }
            col++;
        }
        return true;
    }


}
