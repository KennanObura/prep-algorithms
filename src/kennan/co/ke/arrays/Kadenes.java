package kennan.co.ke.arrays;

/**
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 */
public class Kadenes {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(largestSum(a));
    }

    private static int largestSum(int[] numbers) {
        if (numbers.length == 0) return 0;

        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int num : numbers) {
            current_sum += num;
            current_sum = Math.max(0, current_sum);
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }
}
