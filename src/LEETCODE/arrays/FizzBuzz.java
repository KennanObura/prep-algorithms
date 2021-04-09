package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {

        System.out.println(fizzBuzz(45));

    }

    public static List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
                continue;
            }

            if (i % 5 == 0) {
                result.add("Buzz");
                continue;
            }

            if (i % 3 == 0) {
                result.add("Fizz");
                continue;
            }

            result.add(String.valueOf(i));
        }

        return result;

    }
}
