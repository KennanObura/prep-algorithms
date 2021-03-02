package TECHIEDELIGHT.slidingWindow;

/*
https://www.techiedelight.com/find-maximum-length-sequence-continuous-ones-sliding-window/
Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.
 */
public class MaxSequenceLengthOfContinousOnes {
    public static void main(String[] args) {

        System.out.println(maxOfContinuousOnes(new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}));
        System.out.println(maxOfContinuousOnes(new int[]{0, 0, 1}));
        System.out.println(maxOfContinuousOnes(new int[]{0, 0}));
        System.out.println(maxOfContinuousOnes(new int[]{0}));

    }

    private static int maxOfContinuousOnes(int[] binary) {
        int N = binary.length;
        if(N == 1) return 1;

        int maxLength = 0;
        int K = 1, start = 0;

        for (int i = 0; i < N; i++) {
            int current = binary[i];

            if (current == 0)
                K--;

            while (K < 0) {
                if (binary[start] == 0)
                    K++;
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);

        }
        return maxLength;
    }
}
