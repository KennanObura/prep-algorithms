package HACKERRANK;

public class HourGlass {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int[][] arr1 = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println(hourglassSum(arr));
    }

    private static int hourglassSum(int[][] arr) {
        int maxHrGlass = Integer.MIN_VALUE;
        int top = 0;
        int mid = 0;
        int bot = 0;
        for (int i = 0; i < arr.length - 2; i++) {

            boolean flag = true;
            for (int j = 0; j < arr[0].length; j++) {

                top += arr[i][j];

                if (j > 2)
                    top -= arr[i][j - 2];

                if (flag) {
                    mid = arr[i + 1][j + 1];
                    flag = false;
                }


                bot += arr[i + 2][j];
                if (j > 2)
                    bot -= arr[i + 2][j - 2];

            }
            int sum = top + bot + mid;
            System.out.println(sum);
        }
        return maxHrGlass;

    }


}
