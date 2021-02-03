package kennan.co.ke.arrays;

/**
 * If there are n elements in the array then there will be (n*n+1)/2 subarrays.
 * <p>
 * We will use three loop to print subarrays.
 * Outer loop will be used to get start index
 * First inner loop will be used to get end index
 * Second inner loop will be used to print element from start to end index.
 */
public class PrintAllSubArrays {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        solve(array);
    }

    private static void solve(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k] + ",");
                }
                System.out.println();
            }
        }
    }
}
