package TECHIEDELIGHT.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/*
https://www.techiedelight.com/find-duplicates-within-given-range-array/
Given an array and a positive number k, check whether the array contains any duplicate elements within the range k.
If k is more than the array’s size, the solution should check for duplicates in the complete array.
 */
public class DuplicatesWithinRangeArray {
    public static void main(String[] args) {

        System.out.println(containDuplicates(new int[]{5,6,3,2,4,2}, 3));
    }

    private static boolean containDuplicates(int[] A, int K) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();

        if (K > N) {
            for (int i : A) {
                if (set.contains(i)) return true;
                set.add(i);
            }
        } else {

            int start = 0;

            for (int end = 0; end < N; end++) {
                if (set.contains(A[end]))
                    return true;

                set.add(A[end]);
                K--;

                System.out.println(set);
                while (K < 1) {
                    set.remove(A[start++]);
                    K++;
                }
            }
        }

        return false;
    }
}
