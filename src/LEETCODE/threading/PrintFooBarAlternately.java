package LEETCODE.threading;

import org.junit.jupiter.api.parallel.Execution;

import java.util.concurrent.Semaphore;

/**
 * Suppose you are given the following code:
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */
public class PrintFooBarAlternately {
    public static void main(String[] args) {


    }
}

class FooBarPrinter implements Runnable {

    FooBar fooBar;

    FooBarPrinter(FooBar fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {

    }
}


class FooBar {
    private int n;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;

        try {
            this.fooSemaphore = new Semaphore(1);
            this.barSemaphore = new Semaphore(0);
        } catch (Exception e) {

        }

    }

    public void foo(Runnable printFoo) throws InterruptedException {



        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            barSemaphore.acquire();

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}
