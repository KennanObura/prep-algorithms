package LEETCODE.arrays;

/**
 * 1004. Max Consecutive Ones III
 * Medium
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * <p>
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {

        System.out.println(longestOnes(new int[]{0, 0, 1, 1}, 2));

        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));

        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    // O(N^2)
    public static int longestOnesNaive(int[] A, int K) {
        int N = A.length;
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            int Z = K;

            for (int j = i; j < N && Z >= 0; j++) {
                if (A[j] == 0) Z--;
                maxLength = Math.max(maxLength, j - i);
            }
        }

        return maxLength;
    }


    public static int longestOnes(int[] A, int K) {
        int N = A.length;
        int maxLength = 0;
        int start = 0;
        int Z = K;

        for (int i = 0; i < N; i++) { //1,1,1,0,0,0,1,1,1,1,0
            if (A[i] == 0) Z--;

            while (Z < 0){
                if(A[start] == 0)
                    Z++;
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);

        }

        return maxLength;
    }


}
