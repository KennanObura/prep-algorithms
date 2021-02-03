package HACKERRANK;

import java.util.Arrays;

public class GemStones {
    public static void main(String[] args) {
        String[] arr = {"abcdde", "baccd", "eeabg"};
        System.out.println(gemstones(arr));

    }

    /*
    1. sort string
    2. generate possible substrings from any
    3. check if is in all strings
     */

    static int gemstones(String[] arr) {
        String reference = arr[0];

        int count = 0;
        for (char ch : reference.toCharArray()) {
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].contains(ch + ""))
                    break;
                if (i == arr.length - 1)
                    count++;

            }
        }

        return count;
    }
}

