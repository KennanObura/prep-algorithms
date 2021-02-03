package kennan.co.ke.numbers;

public class NumericPalindrome {
    public static void main(String[] args) {

        System.out.print(isPalindrome(1211));
    }

    private static boolean isPalindrome(long num) {
        return reversed(num) == num;
    }

    private static long reversed(long num) {
        long temp = num;
        long result = 0;

        while (temp != 0) {
            long digit = temp % 10;
            result = result * 10 + digit;
            temp /= 10;
        }
        return result;
    }
}
