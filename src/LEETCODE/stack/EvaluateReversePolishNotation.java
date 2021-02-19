package LEETCODE.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * Medium
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {

        String [] input = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(input));

        System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

        System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[] {"4"}));
    }

    public static int evalRPN(String[] tokens) {

        int N = tokens.length;
        if(N == 0) return 0;
        if(N == 1) return Integer.parseInt(tokens[0]);

        Set<String> operands = new HashSet<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        Stack<Long> stack = new Stack<>();

        int i = 0;
        long tempResult = 0;

        while (i < N) {
            if (operands.contains(tokens[i])) {
                long val1 = stack.pop();
                long val2 = stack.pop();

                switch (tokens[i]) {
                    case "*":
                        tempResult = val2 * val1;
                        break;
                    case "-":
                        tempResult = val2 - val1;
                        break;
                    case "+":
                        tempResult = val2 + val1;
                        break;
                    case "/":
                        tempResult = val2 / val1;
                        break;
                }
                stack.push(tempResult);
            } else {
                stack.push(Long.valueOf(tokens[i]));
            }
            i++;
        }
        return (int) tempResult;
    }
}
