package kennan.co.ke.arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

      int[] arr = {3, 10, 2, 1, 20};
      solve(arr, 0, 1);
    }

    private static void solve(int[] array) {

    }

    private static void solve(int[] array, int pos, int ending_here) {

        if (pos == array.length - 1) {
            System.out.println(ending_here + "");
            return;
        }

        int count = 1;


        for (int i = pos + 1; i < array.length; i++) {
            if (array[i] > array[pos]) count++;
            solve(array, pos + 1, Math.max(ending_here, count));

        }
    }
}
