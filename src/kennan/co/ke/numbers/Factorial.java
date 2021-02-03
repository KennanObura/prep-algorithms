package kennan.co.ke.numbers;

import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(trailingZero(5));
        int [] nums = {2,6,-1,4} ;
        arraySum(nums);
    }

    private static int trailingZero(int num) {
        double fact = factorial(num, 1);

        int count = 0;
        while (fact > 0) {
            fact /= 10;
            count++;
        }
        return count;
    }

    private static void arraySum(int[] nums) {

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        System.out.println(Arrays.toString(sums));
    }

    private static double factorial(int num, double i) {

        for (int n = num; n >= 1; n--)
            i *= n;
        return i;
    }
}
