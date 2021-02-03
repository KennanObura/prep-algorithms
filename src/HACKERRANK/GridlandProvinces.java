package HACKERRANK;

import java.util.HashSet;
import java.util.Set;

public class GridlandProvinces {
    public static void main(String[] args) {

        System.out.println(gridlandProvinces("dab", "abd"));
    }

    static int gridlandProvinces(String s1, String s2) {
        /*
         * Write your code here.
         */
        char[][] grid = new char[2][s1.length()];
        boolean[][] visited;

        for (int i = 0; i < s1.length(); i++) {
            grid[0][i] = s1.charAt(i);
            grid[1][i] = s2.charAt(i);

        }

        Set<String> set = new HashSet<>();


//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[0].length; col++) {
                visited = new boolean[2][s1.length()];
                gridlandProvinces(grid, visited, new StringBuilder(), set, 0, 0);
//            }
//        }

        System.out.println(set);

        return set.size();
    }

    private static void gridlandProvinces(char[][] grid, boolean[][] visited, StringBuilder st, Set<String> set, int row, int col) {
        int end = grid.length * grid[0].length;


        if (st.length() == end) {
            set.add(String.valueOf(st));
            return;
        }

        if (knightCanVisit(visited, row, col) && !visited[row][col]) {
            visited[row][col] = true;
            st.append(grid[row][col]);


            gridlandProvinces(grid, visited, st, set, row + 1, col);
            gridlandProvinces(grid, visited, st, set, row - 1, col);
            gridlandProvinces(grid, visited, st, set, row, col + 1);
            gridlandProvinces(grid, visited, st, set, row, col - 1);
        }

//        st.deleteCharAt(st.length() - 1);
//        visited[row][col] = false;
    }

    private static boolean knightCanVisit(boolean[][] visited, int row, int col) {
        return (row > -1 && row < visited.length && col > -1 && col < visited[0].length);
    }
}
