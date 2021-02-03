package kennan.co.ke.arrays;

/**
 * Given 3 arrays of sorted variables, find min range with at least one elem from each array
 * <p>
 * Solution
 * o(n^3) => use nested loops to find min and max among the arrays. Keep track of min diff
 * <p>
 * Efficient solution
 * Steps
 * - Since arrays are sorted, we consider triples to get min & max from them,
 * - advance position from where min is picked
 * - keep track of diff
 */
public class MinimumRangeGivenArrays {
    public static void main(String[] args) {
        int[] a = {3, 6, 8, 10, 15};
        int[] b = {1, 5, 12};
        int[] c = {4, 8, 15, 16};

        System.out.println(solve(a, b, c));
    }


    private static String solve(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        int min_ = 0;
        int max_ = 0;

        int minDiff = Integer.MAX_VALUE;

        while (i < a.length && j < b.length && k < c.length) {
            int min = Math.min(Math.min(a[i], b[j]), c[k]);
            int max = Math.max(Math.max(a[i], b[j]), c[k]);

            if (minDiff > max - min) {
                minDiff = max - min;
                max_ = max;
                min_ = min;
            }

            if(min == a[i]) i++;
            else if(min == b[j]) j++;
            else k++;
        }
        return min_ + " - " + max_;
    }

}
