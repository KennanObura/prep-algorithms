package SAFCOM;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] items = {-1, 2};
        System.out.println(solution(items));
    }

    static private int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> set = new HashSet<>();

        for (int i : A)
            if (i > 0)
                set.add(i);

        if (set.isEmpty())
            return 1;
        int laregest = Integer.MIN_VALUE;
        for (int i = 1; i <= A.length; i++) {

            if (!set.contains(i))
                return i;
            laregest = Math.max(laregest, i);
        }

        return laregest + 1;
    }
}
