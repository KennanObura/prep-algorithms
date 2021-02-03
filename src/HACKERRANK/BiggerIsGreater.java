package HACKERRANK;

import java.util.Arrays;

public class BiggerIsGreater {
    public static void main(String[] args) {
        String s = "abdc";
        System.out.println(biggerIsGreater(s));

    }

    static String biggerIsGreater(String w) {

        char[] chars = w.toCharArray();
        int index = w.length() - 1;


        while (index > 0 && chars[index] <= chars[index - 1])
            index--;


        if (index == 0)
            return "no answer";

        int i = chars.length - 1;


        if (chars[i] > chars[i - 1]) {
            chars[i] = swap(chars[i - 1], chars[i - 1] = chars[i]);
            return String.valueOf(chars);
        }


        int j = index;
        i = index - 1;

        System.out.println(i);

        while (j < chars.length && chars[i] < chars[j])
            j++;

        j--;

        System.out.println(j);
        chars[i] = swap(chars[j], chars[j] = chars[i]);

        i++;
        j = w.length() - 1;
        while (i < j)
            chars[i] = swap(chars[j], chars[j--] = chars[i++]);


        return String.valueOf(chars);
    }

    private static char swap(char i, char c) {
        return i;
    }
}
