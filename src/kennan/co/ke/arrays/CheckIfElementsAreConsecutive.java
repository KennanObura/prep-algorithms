package kennan.co.ke.arrays;


import java.util.HashSet;
import java.util.Set;

public class CheckIfElementsAreConsecutive {
    public static void main(String[] args) {
        int [] arr= {47, 43, 45, 46, 46};
        System.out.println(solve(arr));
    }

    private static boolean solve(int[] array) {

        Pair edges = getEdges(array, new Pair());

        if (edges.max - edges.min + 1 == array.length) {
            Set<Integer> set = new HashSet<>();

            for (int i : array) {
                if (set.contains(i)) return false;
                set.add(i);
            }
            return true;
        }
        return false;
    }

    private static Pair getEdges(int[] array, Pair pair) {
        for (int i : array) {
            pair.setMax(Math.max(pair.getMax(), i));
            pair.setMin(Math.min(pair.getMin(), i));
        }
        return pair;
    }


    private static class Pair {
        private int min = Integer.MAX_VALUE;
        private int max = Integer.MIN_VALUE;

        public void setMax(int max) {
            this.max = max;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }
    }
}
