package LEETCODE.arrays;

public class SearchTwoDMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix2 = {{1}, {3}};
        int[][] matrix3 = {{1, 3, 5, 7}};
        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix2, 3));
        System.out.println(searchMatrix(matrix3, 3));
    }

//    public static boolean searchMatrix(int[][] matrix, int target) {
//
//        for (int[] row : matrix) {
//            if(target == row[0] || target == row[matrix[0].length-1])
//                return true;
//            else if (target >= row[0] && target <= row[matrix[0].length - 1])
//                return doBinary(row, target, 0, row.length-1);
//            else break;
//        }
//        return false;


//    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int N = matrix.length;
        int row = 0;
        while(row < N){
            if(matrix[row][0] == target)
                return true;
            else if(matrix[row][0] < target)
                row++;
            else{
                break;
            }
        }

        row = row > 0 ? row-1 : row;

        return doBinary(matrix[row], target, 0, N);
    }

    private static boolean doBinary(int[] row, int target, int start, int end) {
        if (start > end) return false;

        int mid = getMid(start, end);

        if (row[mid] == target) return true;

        if (doBinary(row, target, start + 1, end))
            return true;
        else return doBinary(row, target, start, end - 1);
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}
