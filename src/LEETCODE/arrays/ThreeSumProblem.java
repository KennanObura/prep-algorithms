package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSumProblem {
    public static void main(String[] args) {

        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> result = threeSum(nums);

        for (List<Integer> items : result)
            System.out.println(items);

    }

    static private List<List<Integer>> threeSum(int[] nums) {
        //O(NlogN)
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;

        //O(N^2)
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum_temp = nums[i] + nums[start] + nums[end];
                List<Integer> inner = new ArrayList<>();
                if (sum_temp < sum) start++;
                else if (sum_temp > sum) end--;
                else {
                    System.out.println("Elems are " + nums[i] + " , " + nums[start] + " and " + nums[end]);
                    inner.add(nums[i]);
                    inner.add(nums[start]);
                    inner.add(nums[end]);
                    if (!result.contains(inner))
                        result.add(inner); //
                    start++;
                    end--;
                }
            }
        }

        return result;

    }


    static private List<List<Integer>> threeSumHash(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;


        int start = 0;
        int end = nums.length - 1;

//        while (start < end) {
//            int sum_temp =  nums[start] + nums[end];
//            if(map.containsKey(sum_temp) && map.get(sum_temp) != start && map.get(sum_temp) != end){
//                List<Integer> inner = new ArrayList<>();
//                System.out.println("Elems are " + nums + " , " + nums[start] + " and " + nums[end]);
//                inner.add(nums[i]);
//                inner.add(nums[start]);
//                inner.add(nums[end]);
//                if (!result.contains(inner))
//                    result.add(inner); //
//                start++;
//                end--;
//            }
//
//
//            if (sum_temp < sum) start++;
//            else if (sum_temp > sum) end--;
//            else {
//
//            }
//        }


        return result;

    }

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * <p>
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
     * <p>
     * The replacement must be in place and use only constant extra memory.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     * <p>
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     * <p>
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * <p>
     * <p>
     * SOLUTION
     * <p>
     */
    public static class NextPermutation {
        public static void main(String[] args) {

            int[] nums = {1, 2, 3};
            int[] nums1 = {3, 2, 1};
            int[] nums2 = {3, 1, 5, 4, 2};
            nextPermutation(nums);
            nextPermutation(nums1);
            nextPermutation(nums2);
        }


        private static void nextPermutation(int[] nums) {


            int firstIndex = nums.length - 2;

            boolean found = false;
            while (firstIndex >= 0) {
                if (nums[firstIndex] < nums[firstIndex + 1]) {
                    found = true;
                    break;
                }
                firstIndex--;
            }


            if (found) {

                int secondNumber = Integer.MAX_VALUE;
                int j = firstIndex;
                int secondIndex = firstIndex;


                while (j < nums.length) {
                    if (nums[firstIndex] < nums[j] && secondNumber > nums[j]) {
                        secondNumber = nums[j];
                        secondIndex = j;
                    }
                    j++;
                }

                nums[firstIndex] = swap(nums[secondIndex], nums[secondIndex] = nums[firstIndex]);

                reverse(nums, firstIndex + 1, nums.length - 1);


            } else
                reverse(nums, 0, nums.length - 1);

            System.out.println(Arrays.toString(nums));

        }

        private static void reverse(int[] nums, int first, int last) {
            while (first > last)
                nums[first] = swap(nums[last], nums[last--] = nums[first++]);
        }

        static private int swap(int num, int i) {
            return num;
        }


    }
}
