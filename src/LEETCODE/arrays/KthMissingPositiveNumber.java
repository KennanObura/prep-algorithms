package LEETCODE.arrays;

/**
 * 1539. Kth Missing Positive Number
 * <p>
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * <p>
 * Find the kth positive integer that is missing from this array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 * <p>
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));

        System.out.println(findKthPositive(new int[]{1, 2, 3, 4}, 2));

        System.out.println(findKthPositive(new int[]{3, 4}, 2));

        System.out.println(findKthPositive(new int[]{3, 4}, 4));

        System.out.println(findKthPositive(new int[]{3, 4}, 3));
    }

    public static int findKthPositive(int[] arr, int k) {
        int N = arr.length;
        if (N == 0) return k;

        int index = 0;
        int i = 1;
        for (; i <= arr[N - 1]; i++) {

            if (arr[index] == i) {
                index++;
                continue;
            }

            k--;

            if (k == 0)
                return i;
        }

        i--;
        while (k > 0) {
            k--;
            i++;
        }
        return i;
    }
}
