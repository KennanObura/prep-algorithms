package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {9,9, 9};
        int[] digits = {0, 0};
        System.out.println(Arrays.toString(plusOne(digits)));
    }


    static private int[] plusOne(int[] digits) {
        ArrayList<Integer> itemList = new ArrayList<>();

        int first = digits.length - 1;

        boolean added = false;

        while (first >= 0) {
            if (added) {
                itemList.add(digits[first]);
            } else if (digits[first] < 9) {
                itemList.add(digits[first] + 1);
                added = true;
            } else {
                itemList.add(0);
                if (first == 0) itemList.add(1);
            }
            first--;
        }

        int[] res = new int[itemList.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = itemList.get(itemList.size() - 1 - i);
        }

        return res;


    }
}
