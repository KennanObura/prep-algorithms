package LEETCODE.threading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

}

class ZeroEvenOdd {
    private int n;
    private final Semaphore evenSm;
    private final Semaphore oddSm;
    private final Semaphore zeroSm;

    public ZeroEvenOdd(int n) {
        this.n = n;
        evenSm = new Semaphore(0);
        oddSm = new Semaphore(0);
        zeroSm = new Semaphore(1);


    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {

            zeroSm.acquire();
            printNumber.accept(0);
            evenSm.release();
            oddSm.release();

        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            evenSm.acquire();
            if (i % 2 == 0) {
                printNumber.accept(i);
                zeroSm.release();
            }

        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i <= n; i++) {
            oddSm.acquire();
            if (i % 2 != 0) {
                printNumber.accept(i);
                zeroSm.release();
            }

        }

    }
}