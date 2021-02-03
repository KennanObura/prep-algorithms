package CTCI.Moderate;

import java.util.Arrays;

public class SmallestDifferenceOfPairInTwoArrays {
    public static void main(String[] args) {

        System.out.println(minimumDifference(new int[]{1, 3, 15, 2, 11}, new int[]{23, 127, 235, 19, 8}));
    }

    private static int minimumDifference(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;

        int minDiff = Math.abs(A[i] - B[j]);
        int pairA = A[i];
        int pairB = B[j];

        while (i < A.length - 1 && j < B.length - 1) {
            int whenAMoved = Math.abs(A[i + 1] - B[j]);

            int whenBMoved = Math.abs(A[i] - B[j + 1]);

            if (whenAMoved < whenBMoved) {
                pairA = A[i++];
            } else if (whenBMoved < whenAMoved) {
                pairB = A[j++];
            } else {
                pairA = A[i++];
                pairB = A[j++];
            }

            minDiff = Math.min(minDiff, Math.min(whenAMoved, whenBMoved));
        }
        System.out.println(pairA + "|" + pairB);
        return minDiff;
    }
}
