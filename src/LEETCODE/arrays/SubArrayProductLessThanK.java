package LEETCODE.arrays;

/**
 * 713. Subarray Product Less Than K
 * Medium
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */
public class SubArrayProductLessThanK {
    public static void main(String[] args) {

        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 0));
        System.out.println(numSubarrayProductLessThanK(new int[]{1,1,1,1}, 1));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        /*
        Naive solution is to have two nested loops
        for i = 0 ... N
            for j=1 ...N
                prod *= A[j]
                if(prod >= k)
                    break;
                count++;

         Using Sliding window

         let start be start of the curr window
             end be position till current i
             prod = 1;

         for end = 0 ....N
            prod *= A[end] //while prod is less than k

            if prod >= k
                keep removing elem at start from window and advance start

            count += end - start +1
         */
        int N = nums.length;

        if(k <= 1) return 0;


        int start = 0, prod = 1, sumProds = 0;

        for (int end = 0; end < N; end++) {
            prod *= nums[end];

            while (start < N && prod >= k)
                prod /= nums[start++];

            sumProds += end - start + 1;
        }

        return sumProds;
    }
}
