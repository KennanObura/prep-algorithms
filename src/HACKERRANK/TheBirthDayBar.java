package HACKERRANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a chocolate bar, two children, Lily and Ron, are determining how to share it. Each of the squares has an integer on it.
 * <p>
 * Lily decides to share a contiguous segment of the bar selected such that:
 * <p>
 * The length of the segment matches Ron's birth month, and,
 * The sum of the integers on the squares is equal to his birth day.
 * You must determine how many ways she can divide the chocolate.
 * <p>
 * Consider the chocolate bar as an array of squares, s = {2,2,1,3,2} .
 * She wants to find segments summing to Ron's birth day, d=4
 * with a length equalling his birth month, m =2.
 * In this case, there are two segments meeting her criteria: [2,2] and .[1,3]
 */
public class TheBirthDayBar {
    public static void main(String[] args) {

        Integer[] s = {2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1};
        int m = 7;
        int d = 18;
//        System.out.println(birthday(Arrays.asList(s), d, m));
//
        System.out.println(birthdayNaive(Arrays.asList(s), d, m));

//        System.out.println(getNumberOfWays(s.length, d, m, s));
    }

    static int birthday(List<Integer> s, int d, int m) {
        int sum = 0;
        int firstBar = 0;
        int count = 0;
        int length = 0;

        for (Integer i : s) {

            sum += i;
            length++;

            if (sum > d) {
                sum -= s.get(firstBar++);
                length--;
            }

            if (sum == d && length == m)
                count++;

        }

        return count;
    }



    static int birthdayNaive(List<Integer> s, int d, int m) {

        int count = 0;

        int[] cache = new int[s.size()];
        cache[0] = s.get(0);


        for (int i = 1; i < s.size(); i++)
            cache[i] += cache[i - 1] + s.get(i);

        if (m <= s.size() && cache[m - 1] == d) count++;

        for (int i = m; i < s.size(); i++) {
            if (cache[i] - cache[i-m] == d) count++;
        }


        return count;
    }

    public static int getNumberOfWays(int n, int d, int m, int[] sum) {
        // Modify array to make each 'i' contain the running sum of prior elements
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
        }

        // Set number of ways counter
        // If there are >= 'm' squares AND the first possible piece has sum = 'd', 1
        // Else, 0
        int numberOfWays = (m <= n && sum[m - 1] == d) ? 1 : 0;

        // Check the sums for pieces ending at index 'm' through 'n - 1'
        for (int i = m; i < n; i++) {
            // If the sum of the piece is equal to 'd'
            if (sum[i] - sum[i - m] == d) {
                // Increment ways counter
                numberOfWays++;
            }
        }

        return numberOfWays;
    }

}
