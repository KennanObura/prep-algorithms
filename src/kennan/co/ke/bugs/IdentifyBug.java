package kennan.co.ke.bugs;

/**
 * The following program increases/decreases the value of A and B until A is equal to X and B is equal to Y.
 * Find the bug:
 */
public class IdentifyBug {
    public static void main(String[] args) {
        makeTheNumbersMatch(12, 6, 2, 10);
    }

    public static void makeTheNumbersMatch(int a, int b, int x, int y) {
        while (a != x && b != y) {
            if (a > x) {
                a--;
            } else {
                a++;
            }
            if (b > y) {
                b--;
            } else {
                b++;
            }
        }

        while (a != x) {
            if (a > x) {
                a--;
            } else {
                a++;
            }
        }

        while (b != y) {
            if (b > y) {
                b--;
            } else {
                b++;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}
