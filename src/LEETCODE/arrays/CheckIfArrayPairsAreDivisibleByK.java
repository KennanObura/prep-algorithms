package LEETCODE.arrays;

import java.util.Arrays;

public class CheckIfArrayPairsAreDivisibleByK {

    public static void main(String[] args) {

        System.out.println(canArrangeNaive(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        System.out.println(canArrangeNaive(new int[]{1, 2, 3, 4, 5, 6}, 10));
        System.out.println(canArrangeNaive(new int[]{-9, 43, 4, 4, 6, 4, 46, -7, -10, 10, 7, 8, -6, -4, 6, 46, -8, 46, -6, 7, 4, 9, -4, 4}, 50));


    }


    private static boolean canArrangeNaive(int[] arr, int k) {
        /*
        Scan thru array A with one point fixed at i
            scan in nest, to find elem at j, such that
                (A[i] + A[j])%k == 0
                count and mark visited

        for i = 0...N-1
            for j = i+1 ... N
                if((A[i] + A[j])%k == 0)
                    visited(i, j)
                    count ++;
                    break;
         return count*2 == N
         */

        int N = arr.length;
        if (N % 2 != 0) return false;
        boolean[] visited = new boolean[N];
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            if (visited[i]) continue;
            for (int j = i + 1; j < N; j++)
                if (!visited[j] && (arr[i] + arr[j]) % k == 0) {
                    visited[i] = true;
                    visited[j] = true;
                    count++;
                    break;

                }
        }
        System.out.println(count);
        return count * 2 == N;
    }


    private static boolean canArrange(int[] arr, int k) {
        /*
        - Create map and keep remainder r (arr[i]%k) and its frequency to map
        - traverse map,
        - if item directly divisible by k..frequency must be even
        - if item not diretly divisible by K then
            there must exist a number k-r in map
            frequency of such r & k-r must be equal

         */

        int N = arr.length;
        int[] freq = new int[N];

        for (int j : arr) {
            int rem = j % k;
            freq[rem]++;
        }

        if (freq[0] % 2 != 0) return false;

        for (int i = 0; i < N / 2; i++) {

            if (freq[i] != freq[k - i])
                return false;
        }

        return true;


    }
}
