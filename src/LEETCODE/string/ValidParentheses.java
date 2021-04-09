package LEETCODE.string;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{}[]()"));//true
        System.out.println(isValid("{}["));//false
        System.out.println(isValid("{}[()[]]"));//true
        System.out.println(isValid("{}[]({}})")); //false

        System.out.println(isValid("{}[])")); //false
        System.out.println(isValid("({}[])")); //true
        System.out.println(isValid("{]"));//false
        System.out.println(isValid("{"));//false
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char C : s.toCharArray()) {
            if (C == '(' || C == '{' || C == '[')
                stack.push(C);
            else {
                if (C == ')' && stack.isEmpty() || C == '}' && stack.isEmpty() || C == ']' && stack.isEmpty())
                    return false;
                if (!stack.isEmpty()) {
                    char peek = stack.peek();
                    if (C == ')' && peek == '(') stack.pop();
                    else if (C == '}' && peek == '{') stack.pop();
                    else if (C == ']' && peek == '[') stack.pop();
                    else return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
