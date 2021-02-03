package kennan.co.ke.arrays;

import java.util.HashSet;
import java.util.Set;

public class PairsWithSumEqualX {
    public static void main(String[] args) {

        int[] array = {-40, -5, 1, 3, 6, 7, 8, 20};
        solve(array, 15);

    }

    private static void solve(int[] array, int X) {
        Set<Integer> set = new HashSet<>();

        for (int i : array) {
            if (set.contains(X - i))
                System.out.println("Pair (" + (X - i) + ", " + i + ")");
            set.add(i);
        }
    }
}
