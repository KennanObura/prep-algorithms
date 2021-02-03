package kennan.co.ke.arrays;

import java.util.Arrays;

public class MagicIndices {
    public static void main(String[] args) {
        int[] A = {-2, 5, 2, 0, 3, 2};

        int[] B = {1, 2, 2, 0, 3, 2};

        solve(A, B);

    }

    private static int solve(int[] A, int[] B) {

        int[] sumA = new int[A.length];
        sumA[0] = A[0];

        int[] sumB = new int[A.length];
        sumB[0] = B[0];

        int count = 0;

        for (int i = 1; i < A.length; i++) {
            sumA[i] = A[i] + sumA[i - 1];
            sumB[i] = B[i] + sumB[i - 1];
        }

        for (int i = 0; i < A.length; i++)
            if (sumA[i] == sumA[A.length - 1] - sumA[i]
                    && sumB[i] == sumB[A.length - 1] - sumB[i]
                    && sumA[i] == sumB[i]) {
                System.out.print(i + " ,");
                count++;
            }



        System.out.println(Arrays.toString(sumA));
        System.out.println(Arrays.toString(sumB));

        return  count;
    }
}
