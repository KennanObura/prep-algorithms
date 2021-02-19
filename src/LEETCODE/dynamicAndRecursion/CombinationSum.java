package LEETCODE.dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

//        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));

        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {



        combinationSum(candidates, target, 0, new ArrayList<>());
        return result;

    }


    public static void combinationSum(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
//            System.out.println(list);
            return;
        }

        if (index >= candidates.length || target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }

    }
}
