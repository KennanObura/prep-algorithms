package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{3}));

    }

    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > nums.length / 3)
                result.add(entry.getKey());

        return result;
    }
}
