package kennan.co.ke.dynamicProgramingAndRecussion;

import java.util.Arrays;

public class StairsNumOfWays {
    public static void main(String[] args) {

        int[] set = {1,2,3};
        System.out.println(solve(4, set));
    }

    private static int solve(int n, int[] set) {
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for(int coin: set){
            for (int i = 0; i <=n ; i++) {
               if(coin <= i)
                   ways[i] += ways[i-coin];
            }
        }
        System.out.println(Arrays.toString(ways));
        return ways[n];
    }

//    private static int solve(int n, int [] set){
//        if(n == 0) return 0;
//
//
//
//    }
}
