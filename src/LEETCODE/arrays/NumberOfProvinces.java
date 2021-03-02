package LEETCODE.arrays;

public class NumberOfProvinces {
    public static void main(String[] args) {

        int[][] mat1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] mat2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(mat1));
        System.out.println(findCircleNum(mat2));

    }

    public static int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        boolean[][] visited = new boolean[N][N];

        int provinces = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (!visited[row][col] && isConnected[row][col] == 1) {
                    traverseProvince(isConnected, row, col, visited);
                    provinces++;
                }


            }
        }
        return provinces;
    }

    private static void traverseProvince(int[][] isConnected, int row, int col, boolean[][] visited) {
        int N = isConnected.length;
        if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col] || isConnected[row][col] == 0) return;

        visited[row][col] = true;

        traverseProvince(isConnected, row, col + 1, visited);
        traverseProvince(isConnected, row, col - 1, visited);
        traverseProvince(isConnected, row + 1, col, visited);
        traverseProvince(isConnected, row - 1, col, visited);
    }
}
