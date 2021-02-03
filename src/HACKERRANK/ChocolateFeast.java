package HACKERRANK;

public class ChocolateFeast {
    public static void main(String[] args) {
        System.out.println(chocolateFeast(12, 4, 4));

    }


    static int chocolateFeast(int n, int c, int m) {
        if (n < c) return 0;

        int initialBars = n / c;

        int wrappers = initialBars;
        int rem = 0;

        while (wrappers >= m) {
            rem = wrappers % m;

            wrappers /= m;
            initialBars += wrappers;
            wrappers += rem;
        }

        return initialBars;
    }
}
