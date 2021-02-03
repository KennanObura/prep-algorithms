package HACKERRANK;

import java.math.BigInteger;
import java.util.ArrayList;

public class KaprekarNumber {
    public static void main(String[] args) {

        kaprekarNumbers(1, 300);
    }

    static void kaprekarNumbers(int p, int q) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = p; i <= q; i++) {
            if (isValidKaprekar(i))
                list.add(i);
        }

        if (list.isEmpty())
            System.out.println("INVALID RANGE");
        else
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + (i < list.size() - 1 ? ", " : ""));
            }

//        System.out.println(isValidKaprekar(297));
    }

    static boolean isValidKaprekar(int num) {
        long squared = (long) num * num;
        String str = String.valueOf(squared);
        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);
        int numL = left.isEmpty() ? 0 : Integer.parseInt(left);
        int numR = right.isEmpty() ? 0 : Integer.parseInt(right);

        return (numL + numR == num);
    }
}
