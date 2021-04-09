package RANDOM;

import java.util.Stack;

public class PowersOfTwo {
    public static void main(String[] args) {
        printNpowersOfTwoIt(9);
    }

    private static void printNpowersOfTwo(int n) {
        if(n == 1){
            System.out.println(n);
            return;
        }


        int prev = n>>1;
        printNpowersOfTwo(prev);
        int curr = prev <<1;
        System.out.println(curr);
    }

    private static void printNpowersOfTwoIt(int n) {

        Stack<Integer> stack = new Stack<>();

        int i = n;

        while (i >1){
            i = i>>1;
            int curr = i<<1;
            stack.add(curr);
        }
        stack.add(1);

        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
