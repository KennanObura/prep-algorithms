package kennan.co.ke.arrays;

/**
 * We keep pointers, start and end, and move while looping like sliding window
 * while looping
 * if sum ==  target , print (start, end)
 * else
 * if sum is more, reduce sum by elem[start], and move start
 * else add elem[end] to sum, and move end
 */
public class FindSumArrayWithTargetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 9, 0, 11, 8, 1};
        solve(arr, 9);

        solveII(arr, 9);
    }

    private static void solve(int[] array, int target) {

        int sum = 0;
        int start = 0;
        int end = 0;

        while (start < array.length && end <= array.length) {
            if (sum == target) {
                System.out.println(start + " , " + (end - 1));
                if (end <= array.length - 1) {
                    sum += array[end];
                }
                end++;
            } else {
                if (sum > target) {
                    sum -= array[start++];
                } else {
                    sum += array[end++];
                }
            }
        }
    }


    private static void solveII(int[] array, int target) {

        int sum = 0;
        int start = 0;

        System.out.println("++++++++++++++++");
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > target) sum -= array[start++];
            if (sum == target) System.out.println(start + ", " + i);
        }
    }
}
