package LEETCODE.arrays;

import java.util.Arrays;

/**
 * 274. H-Index
 * Medium
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HCitation {
    public static void main(String[] args) {

        int []  citations = {3,0,2, 6,1,5};
        System.out.println(hIndex(citations));
    }

    private static int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        /*
        1 Sort array
        2 loop from left ...N
         compare if Array[i] >= Items equal or greater
         return
         */

        Arrays.sort(citations);
        int N = citations.length;

        for (int i = 0; i < N; i++) {

            if (citations[i] >= N - i)
                return citations[i];

        }
        return 0;
    }
}
