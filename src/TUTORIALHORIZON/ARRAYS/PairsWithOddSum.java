package TUTORIALHORIZON.ARRAYS;

/**
 * Objective: Given an array of integers, write a program to find the number of pairs with even odd.
 * <p>
 * Example:
 * <p>
 * Given Input: [1, 2, 3, 4]
 * Number of odd pairs: 4
 * Note: (1, 2), (1, 4), (2, 3) and (3, 4)
 * <p>
 * Given Input: [6, 7, 1, 3, 2, 5, 4]
 * Number of odd pairs
 */
/*
Approach 1

Have nested loop and check for odd sum. O(N^2)

Approach II
- We know that
        Even+Even = Even
        Odd+Odd = Even
        Even+Odd = Odd.

        We can use this property
    for 0 .. N
        count Even
        count Odd

    OddSum = even+odd (counts)
 */
public class PairsWithOddSum {
    public static void main(String[] args) {
        int[] nums = {6, 7, 1, 3, 2, 5, 4};

        System.out.println(getOddSum(nums));
    }

    private static int getOddSum(int[] nums) {
        int evens = 0;
        int odds = 0;
        for (int i : nums) {
            if (i % 2 == 0) evens++;
            else odds++;
        }
        return (evens * odds);
    }
}
