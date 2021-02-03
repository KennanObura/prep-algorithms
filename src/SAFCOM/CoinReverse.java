package SAFCOM;

import java.util.Arrays;

public class CoinReverse {
    public static void main(String[] args) {
        int[] item = {1, 1, 1, 1, 1};
        System.out.println(solution(item));
    }

    static public int solution(int[] A) {


        int[] cache = new int[A.length];
        int[] cache2 = new int[A.length];
        cache[0] = 1;
        cache2[0] = 0;

        int count1 = A[0] == 1 ? 0 : 1;
        int count2 = A[0] == 0 ? 0 : 1;

        for (int j = 1; j < A.length; j++) {
            if (cache[j - 1] != A[j]) {
                cache[j] = A[j];
            } else {
                cache[j] = cache[j - 1] == 0 ? 1 : 0;
                count1++;

            }


            if (cache2[j - 1] != A[j]) {
                cache2[j] = A[j];
            } else {
                cache2[j] = cache2[j - 1] == 0 ? 1 : 0;
                count2++;

            }

            System.out.println(count1 + " ::count1");
            System.out.println(count2 + " ::count2");

        }

        System.out.println(Arrays.toString(cache));
        System.out.println(Arrays.toString(cache2));

        return Math.min(count1, count2);

    }

    static private int minSequence(int[] A, int index, boolean flag) {
        if (index < 0) return 0;


        int startingZero = 0;
        int startingOne = 0;

        if (flag) {
            if (A[index] != 1) {
                startingOne = minSequence(A, index - 1, false) + 1;
            } else
                startingZero = minSequence(A, index - 1, false) + 1;
        } else {
            if (A[index] != 0) {
                startingOne = minSequence(A, index - 1, true) + 1;
            } else
                startingZero = minSequence(A, index - 1, true) + 1;
        }

        return Math.min(startingOne, startingZero);

    }
}
