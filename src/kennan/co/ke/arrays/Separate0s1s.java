package kennan.co.ke.arrays;

import java.util.Arrays;

public class Separate0s1s {
    public static void main(String[] args) {
        int [] binary = {0,1,0,0,1,1,1,0,1};
        System.out.println(Arrays.toString(solve(binary)));
    }

    private static  int [] solve(int[] binary){
        int start = 0;
        int last = binary.length-1;

        while (start < last){
            if(binary[start] == 0) start++;
            else if (binary[last] == 1) last--;
            else {
                binary[start] = swap(binary[last], binary[last] = binary[start]);
                start++;
                last--;
            }
        }

        return binary;
    }

    private static int swap(int i, int j) {
        return i;
    }

    private static void swap(int[] binary, int i, int j) {
        int temp = binary[i];
        binary[i] = binary[j];
        binary[j] = temp;
    }
}
