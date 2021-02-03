package kennan.co.ke.numbers;

public class NegateNumber {
    public static void main(String[] args) {
        negate(12);
    }

    private static int negate(int number) {

        int sign = number < 0 ? 1 : -1;

        int neg = 0;

        while (number != 0) {
            neg += sign;
            number += sign;
        }
        return neg;
    }
}
