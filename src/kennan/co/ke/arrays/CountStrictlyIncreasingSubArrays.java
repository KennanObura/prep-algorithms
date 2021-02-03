package kennan.co.ke.arrays;

public class CountStrictlyIncreasingSubArrays {
    public static void main(String[] args) {
        int[] items = {1, 2, 4, 4, 5, 6};
        System.out.println(optimized(items));
    }

    // o(n^2)
    private static int optimized(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int innerCount = 1;
            int j = i;

            while (j + 1 < array.length && array[j] < array[j + 1]) {
                innerCount++;
                j++;
            }

            if (innerCount > 1)
                count++;
        }
        return count;
    }
}
