package LEETCODE.arrays;

import java.util.Arrays;

public class ReverseWord {
    public static void main(String[] args) {

        char[] message = {'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l'};
        reverseWords(message);

        System.out.println(Arrays.toString(message));

    }

    public static void reverseWords(char[] message) {

        // decode the message by reversing the words

        int start = 0, end = message.length - 1;

        while (start < end)
            message[start] = swap(message[end], message[end--] = message[start++]);


    }

    private static char swap(char i, char j) {
        return i;
    }
}
