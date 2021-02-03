package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 */
public class SingleElemThatAppearsOnce {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 3, 3, 3};
        System.out.println(singleNumberBit(nums));
        System.out.println(singleNumberHashMap(nums));
    }

    private static int singleNumberHashMap(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet())
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        return result;
    }

    private static int singleNumberBit(int[] nums) {
        int bit = 0;

        for (int num : nums) {
            bit ^= num;
//            bit ^= num;
//            System.out.println(bit);
        }
        return bit;
    }
}
