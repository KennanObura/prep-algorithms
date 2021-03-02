package TECHIEDELIGHT.slidingWindow;

/*
https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/
Given an integer array, find the minimum sum subarray of size
 */
public class MinSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(minSumSubArrayOfSizeK(new int[]{10, 4, 5, 6, 3, 8, 1}, 3));

    }

    private static int minSumSubArrayOfSizeK(int[] A, int K) {
        /*
        - let start be start pointer
            end be end pointer

            - loop from end = 0 ...N

                CASE size < K
                    add items to current sum
                CASE size > K
                    remove items from start and advance start
                CASE size == K
                    min(minSum, currentSUm)

         */
        int N = A.length;

        int start = 0, currentSum = 0, minSum = Integer.MAX_VALUE;

        for (int end = 0; end < N; end++) {
            currentSum += A[end];
            K--;

            while (K < 0) {
                currentSum -= A[start++];
                K++;
            }

            if (K == 0) {
                minSum = Math.min(currentSum, minSum);
            }


        }
        return minSum;
    }
}
