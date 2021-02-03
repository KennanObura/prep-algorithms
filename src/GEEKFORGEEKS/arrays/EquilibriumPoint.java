package GEEKFORGEEKS.arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {

        long[] input = {1};
        System.out.println(equilibriumPoint(input, input.length));
        System.out.println(equilibriumPointNoAuxiliary(input, input.length));
    }

    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long[] pref = new long[n];
        long[] surf = new long[n];

        pref[0] = arr[0];
        for (int i = 1; i < n; i++)
            pref[i] = arr[i] + pref[i - 1];

        surf[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            surf[i] = arr[i] + surf[i + 1];


        int index = -1;
        for (int i = 0; i < n; i++)
            if (pref[i] == surf[i]) {
                index = i + 1;
                break;
            }
        return index;
    }


    public static int equilibriumPointNoAuxiliary(long arr[], int n) {

        // Your code here

        int index = -1;

        int start = 0;
        int end = n - 1;
        long sum_end = arr[start];
        long sum_start = arr[end];

        if(n ==1) index = 1;

        while (start < end) {
            if (sum_start == sum_end)
                index = start + 2;
            if (sum_start < sum_end)
                sum_start += arr[start++];
            else
                sum_end += arr[end--];
        }

        return index;
    }
}
