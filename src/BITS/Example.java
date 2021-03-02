package BITS;

import java.util.Stack;

public class Example {
    public static void main(String[] args) {
        int a = 2;
        int b = 9;

//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(b));
//
//        System.out.println(~a);
//
//        System.out.println(a|b);
//        System.out.println(Integer.toBinaryString(a|b));
//
//        System.out.println(a^b);
//        System.out.println(Integer.toBinaryString(a^b));

        int [] nums = {1,3,1,2,2,4,5,4,5,2,2};

        int oddNum = 0;
        for (int num : nums) {
            oddNum ^= num;
        }
//        System.out.println(oddNum);

        System.out.println(5<<3);
        System.out.println(Integer.toBinaryString(40));


        Stack<Integer> stack = new Stack<>();
        int num = b;
        while (num > 0){
            int rem = num % 2;
            stack.add(rem);
            num /= 2;
        }
        System.out.println(stack);
    }
}
