package LEETCODE.numbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19, new HashSet<>()));
    }


    public static boolean isHappy(int n, Set<Integer> set) {

        if (n == 1 || n == 7) return true;

        if (n < 1 || set.contains(n)) return false;

        int K = n;
        int prod = 1;
        while (K > 0) {
            int dig = K % 10;
            prod += dig * dig;

            K /= 10;
        }

        set.add(prod);

        System.out.println(prod);


        return isHappy(prod, set);
    }
}
