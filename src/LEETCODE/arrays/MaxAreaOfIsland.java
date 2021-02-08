package LEETCODE.arrays;

public class MaxAreaOfIsland {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0}
        };

        int [][] grid2 = {{0,0,0,0,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
        System.out.println(maxAreaOfIsland(grid2));

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int maximumIsland = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int current = maxAreaOfIsland(grid, visited, row, col)+1;
                    System.out.println(current + " --");
                    maximumIsland = Math.max(maximumIsland, current);
                }

            }

        }
        return maximumIsland;

    }

    private static int maxAreaOfIsland(int[][] grid, boolean[][] visited, int row, int col) {

        int count = 0;
        visited[row][col] = true;
        if(isSafe(visited, row+1, col) && grid[row+1][col] != 0) {
            count += maxAreaOfIsland(grid, visited, row + 1, col) + 1;
        }

        if(isSafe(visited, row-1, col) && grid[row-1][col] != 0) {
            count += maxAreaOfIsland(grid, visited, row - 1, col) + 1;
        }

        if(isSafe(visited, row, col+1) && grid[row][col+1] != 0) {
            count += maxAreaOfIsland(grid, visited, row, col+1) + 1;
        }

        if(isSafe(visited, row, col-1) && grid[row][col-1] != 0) {
            count += maxAreaOfIsland(grid, visited, row, col-1) + 1;
        }



        return count;
    }

    private static boolean isSafe(boolean[][] visited, int row, int col) {
        return (row >= 0 && col >=0 && row < visited.length && col < visited[0].length && !visited[row][col]);
    }
}
