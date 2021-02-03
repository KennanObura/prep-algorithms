package kennan.co.ke.numbers;

/**
 * Operations: Write methods to implement the multiply, subtract, and divide operations for integers.
 * The results of all of these are integers. Use only the add operator.
 */
public class NumberOperations {
    public static void main(String[] args) {
        System.out.println(subtract(8, -6));
        System.out.println(multiply(8, -5));
        System.out.println(divide(-8, -4));
    }

    private static int multiply(int a, int b) {
        /* 3 x 4 => 3+3+3+3 = 12
         * 1. Identify the bigger int, faster to increment bigger
         * 2. keep adding till i < smaller int
         * 3. take care of negatives
         */

        if (operationAbs(a) > operationAbs(b))
            return multiply(b, a);

        int max = operationAbs(a);
        int product = 0;
        for (int i = 0; i < max; i++) {
            product = add(product, b);
        }

        return a < 0 ? negate(product) : product;
    }

    private static int operationAbs(int a) {
        return a < 0 ? negate(a) : a;
    }

    private static int subtract(int a, int b) {
        /*
         * a-b => a+(-b)
         * we must negate b => -1*b :: but multiplication is not allowed
         * we must implement negate function
         */

        b = negate(b);
        return add(a, b);
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int negate(int num) {
        if (num == 0) return num;
        int sign = num < 0 ? 1 : -1;
        int negative = 0;

        while (num != 0) {
            negative += sign;
            num += sign;
        }
        return negative;
    }

    private static int divide(int a, int b) {
        if (b == 0) throw new RuntimeException("Division by zero not allowed");
        /*
         * 18/3 => 3+3+3+3... n <=18
         *
         * 6/2
         */
        int n = 0;                      //6
        int count = 0;                  //3
        while (n < operationAbs(a)) {
            n = add(n, operationAbs(b));              //6
            count++;                    //3
        }

        if ((b < 0))
            return negate(count);
        return count;
    }
}
