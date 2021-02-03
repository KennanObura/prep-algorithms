package kennan.co.ke.arrays;

/**
 * Kadane’s Algorithm:
 * <p>
 * Initialize:
 * max_so_far = 0
 * max_ending_here = 0
 * <p>
 * Loop for each element of the array
 * (a) max_ending_here = max_ending_here + a[i]
 * (b) if(max_so_far < max_ending_here)
 * max_so_far = max_ending_here
 * (c) if(max_ending_here < 0)
 * max_ending_here = 0
 * return max_so_far
 */
public class LargestSumOfContiguousSubArray {
    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(solve(array) + "");
    }

    private static int solve(int[] array) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i : array) {
            max_ending_here += i;
            max_ending_here = Math.max(0, max_ending_here);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }

}
