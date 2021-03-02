package TECHIEDELIGHT.binary;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.Stack;

/*
https://www.techiedelight.com/expression-tree/
 */
public class ExpressionTree {
    public static void main(String[] args) {

        String s = "ab+cde+**";

        System.out.println(constructExpression(s));
    }

    /*
    To make infix notation
    - create stack of string
    - from i = 0... N
        put string/values to stack
        if values is operator
            pop two values from string
            operate on them and push to stack[construct operation]
        Repeat
     */

    private static TreeNode constructExpression(String postfix) {

        Stack<String> stack = new Stack<>();
        Stack<TreeNode> nodeStack = new Stack<>();


        for (char character : postfix.toCharArray()) {

            if (character == '*') {
                constructExpression('*', stack);
            } else if (character == '+') {
                constructExpression('+', stack);
            } else if (character == '-') {
                constructExpression('-', stack);
            } else if (character == '/') {
                constructExpression('/', stack);
            } else
                stack.push(String.valueOf(character));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());


        System.out.println(sb);

        return new TreeNode(1);
    }

    static void constructExpression(char op, Stack<String> stack) {
        String B = stack.pop();
        String A = stack.pop();
        String opResult = "(" + A + op + B + ")";
        stack.push(opResult);
    }

}
