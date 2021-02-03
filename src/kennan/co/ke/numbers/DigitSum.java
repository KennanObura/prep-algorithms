package kennan.co.ke.numbers;

public class DigitSum {
    public static void main(String[] args) {
        System.out.print(getSum(-10));
    }

    private static int getSum(int number) {
        long i = Math.abs(number);
        long sum = 0;

        while (i != 0) {
            long dig = i % 10;
            sum += dig;
            i /= 10;
        }
        return (int)sum;
    }
}
