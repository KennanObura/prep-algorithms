package TECHIEDELIGHT.dynamicAndRecusion;

/**
 * Given an array A of integers, maximize the value of expression (A[s]-A[r]+A[q]-A[p]) where
 * p, q , r and s are indices of the input array and s > r > q > p
 * <p>
 * Example
 * input : {3,9,10,1,30,40}
 * <p>
 * output:
 * 46
 * <p>
 * Explanation
 * (40-1+10-3)
 * <p>
 * <p>
 * SOLUTION
 * Naive will result to n^4 [Not able to implement]
 * <p>
 * Using DP
 * <p>
 * <p>
 * We can separately  (with for temp arrays)
 * -   keep track of MAX of A[s]
 * <p>
 * -   keep track of MAX of A[s]-A[r]
 * <p>
 * -   keep track of MAX of A[s]-A[r]+A[q]
 * <p>
 * -   keep track of MAX of A[s]-A[r]+A[q]-A[p]
 */
public class MaxValueOfExpression {
    public static void main(String[] args) {

    }

    private static int maxValueOfExpression(int[] A) {

        return 0;
    }

    private static int maxValueOfExpression(int[] A, int index, int N) {

        if (index <= 0) return 0;

        int firstExp = Integer.MIN_VALUE;

        if (N - index >= 4)
            firstExp = Math.max(firstExp, maxValueOfExpression(A, index - 1, N));

        int secondExp = Integer.MIN_VALUE;
        if (N - index >= 3)
            secondExp = Math.max(secondExp, maxValueOfExpression(A, index - 1, N));
        return 0;
    }
}
