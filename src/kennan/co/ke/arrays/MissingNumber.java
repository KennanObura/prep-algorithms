package kennan.co.ke.arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr1 = {7, 5, 6, 1, 4, 2};
        System.out.println(solve(arr1));
    }

    private static int solve(int[] array) {
        int currentSum = 0;
        int expectedSum = getSum(array.length + 1);
        for (int i: array)
            currentSum += i;
        return expectedSum - currentSum;
    }

    private static int getSum(int i) {
        return i * (i + 1) / 2;
    }
}
