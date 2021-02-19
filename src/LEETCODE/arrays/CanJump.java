package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

public class CanJump {
    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));

        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));

        System.out.println(canJump(new int[]{0}));

        System.out.println(canJump(new int[]{0, 1}));

        System.out.println(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));

    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        Map<Integer, Boolean> dp = new HashMap<>();
//        dp.put(0, true);
        return canJump(nums, 0, dp);
    }


    private static boolean canJump(int[] nums, int index, Map<Integer, Boolean> dp) {
        int N = nums.length;
        if (index == N - 1) return true;

        if (dp.containsKey(N))
            return dp.get(N);

        if (nums[index] == 0) return false;


        int furthestJump = Math.min(index + nums[index], nums.length - 1);
        for (int i = index + 1; i <= furthestJump; i++) {
            if (canJump(nums, i, dp)) {
                dp.put(N, true);
                return true;
            }
        }
        dp.put(N, false);
        return false;
    }
}
