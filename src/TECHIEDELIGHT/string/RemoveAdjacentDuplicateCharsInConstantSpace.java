package TECHIEDELIGHT.string;

import java.util.Arrays;

public class RemoveAdjacentDuplicateCharsInConstantSpace {
    public static void main(String[] args) {

        char[] word = {'A', 'A', 'A', 'B', 'B', 'C', 'D', 'D', 'F'};
        removeDuplicate(word);

    }


    private static void removeDuplicate(char[] word) {
        char prev = '/';
        int index = 0;
        for (char item : word) {
            if (item == prev) continue;
            word[index++] = item;
            prev = item;
        }

        for (int i = 0; i < index; i++)
            System.out.print(word[i]);
    }


}
