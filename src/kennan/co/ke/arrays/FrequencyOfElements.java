package kennan.co.ke.arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,4,3,2,5,5};
        solve(arr);
    }

    private static void solve(int[] nums) {
        if (nums.length == 1) return;

        Map<Integer, Integer> frequency = new HashMap<>();

        for(int i: nums)
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);


        for(Map.Entry<Integer, Integer> entry : frequency.entrySet())
            System.out.println("Frequency of " + entry.getKey() + "is :" + entry.getValue());
    }
}
