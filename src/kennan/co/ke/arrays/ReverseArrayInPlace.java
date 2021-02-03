package kennan.co.ke.arrays;

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        char [] items = {'A', 'B', 'C', 'D'};

        System.out.print(Arrays.toString(items));
        solve(items);
        System.out.print(Arrays.toString(items));
    }

    static void solve(char[] characters) {
        int start = 0, last = characters.length - 1;

        while (start < last)
            characters[start] = swap(characters[last], characters[last--] = characters[start++]);
    }

    private static char swap(char character, char c) {
        return character;
    }
}
