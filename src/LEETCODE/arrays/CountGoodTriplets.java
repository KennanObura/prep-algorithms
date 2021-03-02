package LEETCODE.arrays;

/**
 * 1534. Count Good Triplets
 * Easy
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
 * <p>
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
 * <p>
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 * <p>
 * Return the number of good triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * Output: 4
 * Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
 */
public class CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0, 1));
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7}, 7, 2, 3));
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int N = arr.length;

        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i+1; j < N - 1; j++) {
                for (int k = j+1; k < N; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }

                }

            }
        }
        return count;

    }
}
