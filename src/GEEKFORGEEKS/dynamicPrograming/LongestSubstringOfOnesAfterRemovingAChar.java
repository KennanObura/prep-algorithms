package GEEKFORGEEKS.dynamicPrograming;

public class LongestSubstringOfOnesAfterRemovingAChar {
    public static void main(String[] args) {
        int[] bin = {1, 1, 0, 1};
        int[] bin2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};

        System.out.println(longestSubstring(bin));
        System.out.println(longestSubstring(bin2));

    }

    /*
     * SOLUTION
     * Traverse the string scanning for zero, keep count of 1s between two zeros
     * Add the count of 1st till zero to prev 1s. 
     *
     *
     * @param binary
     * @return
     */

    private static int longestSubstring(int[] binary) {
        int i = 0;
        int maxLength = Integer.MIN_VALUE;
        int prevOnes = 0;

        while (i < binary.length) {
            int onesFromHere = 0;

            int k = i;
            while (k < binary.length && binary[k] == 1) {
                onesFromHere++;
                k++;
            }
            if (k < binary.length && binary[k] == 0)
                k++;

            i = k;
            maxLength = Math.max(maxLength, onesFromHere + prevOnes);
            prevOnes = onesFromHere;

        }

        return maxLength;
    }


}
