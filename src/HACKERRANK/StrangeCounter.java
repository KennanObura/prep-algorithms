package HACKERRANK;

public class StrangeCounter {
    public static void main(String[] args) {
        System.out.println(strangeCounter(19));

    }

    static long strangeCounter(long t) {
        int n = 3;
        long multiple = 1;
        long index = n - 2;
        long initBlockCounter;

        while (index <= t) {
            multiple *= 2;

            initBlockCounter = multiple * n;
            index = initBlockCounter - 2;
        }

        long counter = 1;
        while (t < index) {
            index--;
            counter++;

        }

        return counter - 1;

    }

}
