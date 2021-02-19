package LEETCODE.arrays;

/**
 * 275. H-Index II
 * Medium
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note:
 * <p>
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 */
public class HIndex {
    public static void main(String[] args) {

        int[] citations = {0, 1, 2, 6, 5};
        System.out.println(hIndex(citations));

    }

       /*
    O(logN) complexity
     */

    public static int hIndex(int[] citations) {

        return hIndex(citations, 0, citations.length - 1);

    }

    private static int hIndex(int[] citations, int start, int end) {

        int N = citations.length;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            int hIndex = N - mid;
            if (citations[mid] == hIndex)
                return hIndex;
            else if (citations[mid] < hIndex)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return N - start; /* Case 2** Here h index will not be any citation provided in input
         e.g citations[]={1,5,6,7,8} h-index=4 */

    }


    /*
    O(N) complexity
     */
    public int hIndexI(int[] citations) {

        int N = citations.length;
        for (int i = 0; i < N; i++) {
            int remIndex = N - i;

            if (citations[i] >= remIndex)
                return remIndex;
        }

        return 0;

    }
}
