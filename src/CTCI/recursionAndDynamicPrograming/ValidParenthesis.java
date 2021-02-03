package CTCI.recursionAndDynamicPrograming;

import java.util.ArrayList;

/**
 * Given integer N, design an algorithm to print all valid parenthesis
 * <p>
 * <p>
 * SOLUTION
 * <p>
 * Start from index = 0;
 * leftRem = N/2
 * rightRem = N/2
 * Insert the left char and recur with leftRem-1
 * Insert the right char and recur with rightRem-1
 * <p>
 * Base Case
 * index >= N || rightRem > leftRem
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        int N = 3;
        validParenthesis(N);
    }

    private static void validParenthesis(int n) {
        char[] charList = new char[n * 2];
        ArrayList<String> result = new ArrayList<>();
        validParenthesis(0, n, n, charList, result);
        System.out.println(result.size());
        for (String i : result)
            System.out.println(i);
    }

    private static void validParenthesis(int i, int leftRem, int rightRem, char[] charList, ArrayList<String> result) {
        if (i > charList.length || leftRem < 0 || rightRem < leftRem)
            return;

        if (leftRem == 0 && rightRem == 0) {
            result.add(String.valueOf(charList));
            return;
        }

        charList[i] = '(';
        validParenthesis(i + 1, leftRem - 1, rightRem, charList, result);

        charList[i] = ')';
        validParenthesis(i + 1, leftRem, rightRem - 1, charList, result);

    }


}
