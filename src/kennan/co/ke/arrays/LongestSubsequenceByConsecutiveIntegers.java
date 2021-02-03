package kennan.co.ke.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsequenceByConsecutiveIntegers {
    public static void main(String[] args) {
        int[] array = {2, 0, 6, 1, 5, 3, 7};

        System.out.println(solve(array));
    }

    private static int solve(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int i : array)
            set.add(i);

        int maxLength = 0;
        for (int i : array) {
            int j = i;
            int count = 0;
            while (set.contains(j++))
                count++;

            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
