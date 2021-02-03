package kennan.co.ke.arrays;

public class MinNumberOfDeletes {
    public static void main(String[] args) {

        String string = "ABABABABA";

        System.out.println(solution(string));

    }

    private static int solution(String string) {

        char CHAR_A = 'A';
        char CHAR_B = 'B';

        int counterBs = 0, counterIncreasing = 0;
        boolean seen = false;

        for (int i = 0; i < string.length() - 1; i++) {
            char c = string.charAt(i);
            if (c == CHAR_B) counterBs++;

            if (!seen && c == CHAR_A && string.charAt(i + 1) == CHAR_B) {
                counterIncreasing++;
                seen = true;
            }
            if (seen && c == CHAR_B)
                counterIncreasing++;

            if (!seen && c == CHAR_A)
                counterIncreasing++;

        }

        if (string.charAt(string.length() - 1) == CHAR_B) {
            counterBs += 1;
            counterIncreasing += 1;
        }

        return string.length() - Math.max(counterBs, counterIncreasing);
    }
}
