package kennan.co.ke.numbers;

public class TrailingZeroInFactorial {
    public static void main(String[] args) {
        System.out.println(countTrailingZeros(19));
    }

    /**
     * Solution
     * If a number has trailing zero, means it has multiple of 10 eg 120, 10*12
     * Only two factors (5 and 2) can contribute to 10
     * Counting only 5 is sufficient enough to aid us get trailing zero counts
     *
     * General Idea,
     * Whatever number is given, keep dividing by powers of 5 , till the result is less than 1.
     *
     * Example: 100
     *  100/5 = 20
     *  100/25 = 4
     *  100/125 < 0 ....stop
     *  Total Trailing zero = 20+4 = 24;
     *
     */
    private static int countTrailingZeros(int number) {
        int count = 0;
        int rem = 1;
        int powersOfFive = 1;

        while (rem > 0) {
            powersOfFive *= 5;
            rem = number / powersOfFive;
            count += Math.floor(rem);
        }
        return count;
    }
}
