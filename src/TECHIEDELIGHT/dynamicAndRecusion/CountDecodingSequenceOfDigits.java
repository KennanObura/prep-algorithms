package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * https://www.techiedelight.com/count-decodings-sequence-of-digits/
 * <p>
 * Given a positive number,map its digits to the corresponding alphabet in mapping table ([1, A], [2, B]...[26, Z])
 * and return the total number of decodings possible
 * <p>
 * Example
 * 123
 * <p>
 * output 3
 * Explanations
 * ABC
 * AW
 * LC
 */
public class CountDecodingSequenceOfDigits {
    public static void main(String[] args) {


        System.out.println(numberOfDecondings(1221));
    }

    private static int numberOfDecondings(int number) {

        char[] characters = String.valueOf(number).toCharArray();

        return numberOfDecondings(characters, characters.length - 1);
    }

    /**
     * Recursivley add number of ways to map into single digits of 1-9
     * + number of ways to map into two digits of 10-26
     *
     * @param characters
     * @param N
     * @return
     */

    private static int numberOfDecondings(char[] characters, int N) {

        if (N == 0 || N == -1) return 1;
        if (N < -1) return 0;


        int sum = 0;
        if (characters[N] >= '1' && characters[N] <= '9') {
            sum += numberOfDecondings(characters, N - 1);
        }

        if ((characters[N - 1] == '1' || characters[N - 1] == '2') && characters[N] <= '6') {
            sum += numberOfDecondings(characters, N - 2);
        }

        return sum;
    }
}
