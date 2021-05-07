package LEETCODE.arrays;

/**
 * 896. Monotonic Array
 * Easy
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: [6,5,4,4]
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: [1,2,4,5]
 * Output: true
 * <p>
 * Example 5:
 * <p>
 * Input: [1,1,1]
 * Output: true
 */
public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3})); //true
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));//true
        System.out.println(isMonotonic(new int[]{1, 3, 2})); //false
        System.out.println(isMonotonic(new int[]{1, 2, 4, 5})); //true
        System.out.println(isMonotonic(new int[]{1, 1, 1})); //true
    }

    public static boolean isMonotonic(int[] A) {
        int N = A.length;
        boolean increasing = true;
        boolean decreasing = true;


        for (int i = 1; i < N; i++)
            if (A[i - 1] > A[i]) {
                increasing = false;
                break;
            }

        for (int i = 1; i < N; i++)
            if (A[i - 1] < A[i]) {
                decreasing = false;
                break;
            }

        return increasing || decreasing;
    }
}
