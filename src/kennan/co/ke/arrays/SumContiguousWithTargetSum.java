package kennan.co.ke.arrays;

public class SumContiguousWithTargetSum {
    public static void main(String[] args) {

        int [] num = {2,3,4,1,0,6,3};
        solve(num, 8);
    }

    private static void solve(int[] array, int K) {
        int sum = 0;
        int start = 0;
        int end = 0;

        while (start < array.length && end < array.length) {
            if (sum > K) {
                sum -= array[start++];
            }else if (sum == K) break;

            sum += array[end++];
        }

        for (int i = start; i < end ; i++) {
            System.out.print(array[i]);
        }


    }
}
