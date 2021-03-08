package TUTORIALHORIZON.ARRAYS;

import java.util.Arrays;
import java.util.Collections;

public class MinimumDeletionToMakeOccurrenceOfCharUnique {
    public static void main(String[] args) {

        System.out.println(minimumDeletion("aaaaabbbbb"));
        System.out.println(minimumDeletion("abcaabbcdaab"));
        System.out.println(minimumDeletion("aaaabbbbccccdddd"));
    }

    static int minimumDeletion(String input) {
        /*
        - create a frequency array of size 26
        - loop through string and count occurrences

        - Sort array in reverse
        - loop to calculate diff

        let prev = first elem in freq
        for i = 1 ...N
            if prev <= ith elem
                calculate diff (ith elem - prev +1) and add to count
                update ith elem
                 ith elem = prev -1


         */


        Integer[] freq = new Integer[26];

        Arrays.fill(freq, 0);

        for (char ch : input.toCharArray()) {
            int i = ch - 'a';
            freq[i]++;
        }


        Arrays.sort(freq, Collections.reverseOrder());


        int prev = freq[0];
        int totalDeletion = 0;

        for (int i = 1; i < freq.length; i++) {
            int elem = freq[i];
            if (elem == 0) break;

            if (prev <= elem) {
                totalDeletion += (elem - prev) + 1;
                freq[i] = Math.max(prev, 0);
                freq[i]--;
            }

            prev = freq[i];

        }

        return totalDeletion;

    }
}
