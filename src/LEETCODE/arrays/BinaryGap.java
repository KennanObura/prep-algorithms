package LEETCODE.arrays;

/**
 * 868. Binary Gap
 * https://leetcode.com/problems/binary-gap/
 * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
 * <p>
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 22
 * Output: 2
 * Explanation: 22 in binary is "10110".
 * The first adjacent pair of 1's is "10110" with a distance of 2.
 * The second adjacent pair of 1's is "10110" with a distance of 1.
 * The answer is the largest of these two distances, which is 2.
 * Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: 2
 * Explanation: 5 in binary is "101".
 * Example 3:
 * <p>
 * Input: n = 6
 * Output: 1
 * Explanation: 6 in binary is "110".
 * Example 4:
 * <p>
 * Input: n = 8
 * Output: 0
 * Explanation: 8 in binary is "1000".
 * There aren't any adjacent pairs of 1's in the binary representation of 8, so we return 0.
 * Example 5:
 * <p>
 * Input: n = 1
 * Output: 0
 */
public class BinaryGap {
    public static void main(String[] args) {

//        System.out.println(binaryGap(1));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
    }

    public static int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);

        int N = binary.length();
        boolean isBetween = false;
        int maxGap = 0;
        int count = 0;

        System.out.println(binary);


        for (int i = 0; i < N; i++) {


        }
        return maxGap;
    }

}
