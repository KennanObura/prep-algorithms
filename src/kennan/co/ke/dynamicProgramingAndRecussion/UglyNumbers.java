package kennan.co.ke.dynamicProgramingAndRecussion;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5
 * <p>
 * Method 1 (Simple)
 * Loop for all positive integers until ugly number count is smaller than n,
 * if an integer is ugly than increment ugly number count.
 * <p>
 * <p>
 * <p>
 * To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5,
 * if the number becomes 1 then it is an ugly number otherwise not.
 */
public class UglyNumbers {
    public static void main(String[] args) {
        System.out.println(solve(7));
    }

    private static int solve(int number) {

        int count = 1; //
        int initial = 1;

        while (count < number)
            if (isUgly(initial++)) count++;
        return initial;
    }

    private static boolean isUgly(int number) {
        int TWOS = 2;
        int THREES = 3;
        int FIVES = 5;

        number = divideByPowers(number, TWOS);
        number = divideByPowers(number, THREES);
        number = divideByPowers(number, FIVES);

        return number == 1;
    }

    private static int divideByPowers(int number, int powers) {
        while (number % powers == 0)
            number = number / powers;
        return number;
    }
}
