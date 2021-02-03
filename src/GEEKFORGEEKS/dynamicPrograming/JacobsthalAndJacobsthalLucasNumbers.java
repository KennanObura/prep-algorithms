package GEEKFORGEEKS.dynamicPrograming;

import kennan.co.ke.core.Pair;

/**
 * The Jacobsthal sequence is an additive sequence similar to the Fibonacci sequence, defined by the recurrence relation Jn = Jn-1 + 2Jn-2, with initial terms J0 = 0 and J1 = 1. A number in the sequence is called a Jacobsthal number. They are a specific type of Lucas sequence Un(P, Q) for which P = 1 and Q = -2.
 * The first Jacobsthal numbers are:
 * 0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10923, 21845, 43691, ……
 * <p>
 * Jacobsthal-Lucas numbers
 * Jacobsthal-Lucas numbers represent the complementary Lucas sequence Vn(1, -2). They satisfy the same recurrence relation as Jacobsthal numbers but have different initial values:{\displaystyle L_{n}=\left\{\begin{matrix} 2   &   &  if n=0\\1&&ifn=1  \\ L_{n-1} + 2L_{n-2}&&ifn>1  \end{matrix}\right.}
 * <p>
 * Given a positive integer n. The task is to find nth Jacobsthal and Jacobsthal-Lucas numbers.
 */
public class JacobsthalAndJacobsthalLucasNumbers {
    public static void main(String[] args) {

        System.out.println(jacobsthalSequence(7));

    }

    //Recursion 0(2^N)
//    static int jacobsthalSequence(int n) {
//        if (n <= 0) return 0;
//        if (n == 1) return 1;
//        return jacobsthalSequence(n - 1) +
//                jacobsthalSequence(n - 2) * 2;
//    }

    //Bottom up solution
    static Pair<Integer, Integer> jacobsthalSequence(int n) {
        int[] jacobsthal = new int[n + 1];
        jacobsthal[1] = jacobsthal[2] = 1;

        int[] lucas = new int[n + 1];
        lucas[0] = 2;
        lucas[1] = 1;
        lucas[1] = 5;

        for (int i = 2; i <= n; i++) {
            jacobsthal[i] = jacobsthal[i - 1] + 2 * jacobsthal[i - 2];
            lucas[i] = lucas[i - 1] + 2 * lucas[i - 2];
        }

        return new Pair<>(jacobsthal[n], lucas[n]);
    }
}
