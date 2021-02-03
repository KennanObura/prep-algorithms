package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TupleWithSameProduct {
    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();
        int[] num = {2, 3, 4, 6};
        tupleSameProduct(num, 0, result);
        System.out.println(result);
    }

    public static void tupleSameProduct(int[] nums, int index, List<List<Integer>> result) {
        if (index >= nums.length)
            return;

        int k = 0;

//        System.out.println(Arrays.toString(nums));


        for (int i = index + 1; i < nums.length; i++) {
            nums[index] = swap(nums[i], nums[i] = nums[index]);
            if (nums[k] * nums[k + 1] == nums[k + 2] * nums[k + 3]) {
                List<Integer> items = Arrays.asList(nums[k], nums[k + 1], nums[k + 2], nums[k + 3]);
                result.add(items);
            }

            tupleSameProduct(nums, index + 1, result);

            nums[index] = swap(nums[i], nums[i] = nums[index]);


        }



    }

    private static int swap(int num, int i) {
        return num;
    }
}
