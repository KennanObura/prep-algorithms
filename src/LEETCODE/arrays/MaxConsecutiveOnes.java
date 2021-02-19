package LEETCODE.arrays;

/**
 * 485. Max Consecutive Ones
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {

        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));

        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(findMaxConsecutiveOnes(new int[]{}));

        System.out.println(findMaxConsecutiveOnes(new int[]{0, 0, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1}));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {

        int N = nums.length;
        if (N == 0) return 0;
        int maxLength = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxLength = Math.max(maxLength, count);
            } else
                count = 0;
        }
        return maxLength;
    }
}
