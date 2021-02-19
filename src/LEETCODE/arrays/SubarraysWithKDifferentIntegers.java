package LEETCODE.arrays;

import java.util.HashSet;
import java.util.Set;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {

        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));


        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));

        System.out.println(subarraysWithKDistinct(new int[]{}, 1));
    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        int N = A.length;


        int count = 0;
        for (int i = 0; i < N - K + 1; i++) {

            Set<Integer> set = new HashSet<>();
            for (int j = i; j < N && set.size() <= K; j++) {

                set.add(A[j]);

                if (set.size() == K) count++;

            }

        }
        return count;
    }
}
