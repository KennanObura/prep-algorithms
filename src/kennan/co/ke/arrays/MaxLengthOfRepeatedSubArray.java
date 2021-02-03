package kennan.co.ke.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaxLengthOfRepeatedSubArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3, 2, 1};
        int[] B = {1, 4, 3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }

    public static int findLength(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++)
            map.put(A[i], i);

        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                int j = map.get(B[i]);

                while (j < A.length && i < B.length && B[i++] == A[j++])
                    count++;

                i--;
            }

            max = Math.max(count, max);
            count = 0;

        }

        return max;

    }
}
