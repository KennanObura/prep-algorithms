package HACKERRANK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeautifulTriplet {
    public static void main(String[] args) {
        System.out.println(beautifulTriplets(3, new int[]{1, 2, 4, 5, 7, 8, 10}));
    }

    static int beautifulTriplets(int d, int[] arr) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);

        for (int j : arr) {
            if (map.containsKey(j + d) && map.containsKey(j + d + d))
                count++;

        }

        return count;
    }

}
