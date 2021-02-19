package LEETCODE.string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }

    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> digMapList = new ArrayList<>();
        digMapList.add(map[2]);
        digMapList.add(map[3]);

        letterCombinations(digits, digMapList, new StringBuilder(), digMapList.get(0), 0);

        return new ArrayList<>();

    }


    private static void letterCombinations(String digits, List<String> digMapList, StringBuilder res, String current, int index) {

        int N = digits.length();
        int currLength = current.length();
//        System.out.println(res.length());
        if(index >= currLength) return;

        if (res.length() == N) {
            System.out.println(res);
            return;
        }


        for (String s : digMapList) {
            res.append(s.charAt(index));
            letterCombinations(digits, digMapList, res, s, index + 1);
            res.deleteCharAt(res.length() - 1);
        }
    }
}
